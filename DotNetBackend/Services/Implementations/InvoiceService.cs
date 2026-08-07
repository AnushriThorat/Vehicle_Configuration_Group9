using AutoMapper;
using DotNetBackend.Data;
using DotNetBackend.DTOs.Invoice;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class InvoiceService : IInvoiceService
    {
        private readonly IInvoiceRepository _invoiceRepository;
        private readonly IInvoiceDetailRepository _detailRepository;
        private readonly ApplicationDbContext _context;
        private readonly IMapper _mapper;
        private readonly IMailClientService _mailClient;

        public InvoiceService(
            IInvoiceRepository invoiceRepository,
    IInvoiceDetailRepository detailRepository,
    ApplicationDbContext context,
    IMapper mapper,
    IMailClientService mailClient)
        {
            _invoiceRepository = invoiceRepository;
            _detailRepository = detailRepository;
            _context = context;
            _mapper = mapper;
        }

        #region Private Methods

        private double CalculateNetAmount(double basePrice, List<InvoiceItemDto> items)
        {
            double delta = items.Sum(x => x.DeltaPrice);
            return basePrice + delta;
        }

        private double CalculateTax(double netAmount)
        {
            const double GST = 0.18;
            return netAmount * GST;
        }

        private double CalculateTotal(double netAmount, double tax)
        {
            return netAmount + tax;
        }

        #endregion

        #region Generate Invoice

        public InvoiceResponseDto GenerateInvoice(InvoiceRequestDto request)
        {
            if (request == null)
                throw new Exception("Invalid Request.");

            if (request.Items == null || !request.Items.Any())
                throw new Exception("Invoice must contain at least one component.");

            var model = _context.ModelMasters
                .FirstOrDefault(x => x.ModelId == request.ModelId);

            if (model == null)
                throw new Exception("Model not found.");

            var user = _context.Users
                .FirstOrDefault(x => x.Id == request.UserId);

            if (user == null)
                throw new Exception("User not found.");

            double basePrice = Convert.ToDouble(model.BasePrice);

            double netAmount = CalculateNetAmount(basePrice, request.Items);

            double tax = CalculateTax(netAmount);

            double total = CalculateTotal(netAmount, tax);

            using var transaction = _context.Database.BeginTransaction();

            try
            {
                Invoice invoice = new Invoice
                {
                    InvDate = DateTime.Now,
                    Id = user.Id,
                    ModelId = model.ModelId,
                    NetAmt = netAmount,
                    Tax = tax,
                    TotalAmt = total
                };

                _invoiceRepository.AddInvoice(invoice);
                _context.SaveChanges();

                List<InvoiceDetail> details = new();

                foreach (var item in request.Items)
                {
                    details.Add(new InvoiceDetail
                    {
                        InvId = invoice.InvId,
                        ModelId = request.ModelId,
                        CompId = item.CompId,
                        AltCompId = item.AltCompId,
                        DeltaPrice = item.DeltaPrice
                    });
                }

                _detailRepository.AddRange(details);

                _context.SaveChanges();

                transaction.Commit();

                return GetInvoice(invoice.InvId);
            }
            catch
            {
                transaction.Rollback();
                throw;
            }
        }

        #endregion

        #region Get Invoice

        public InvoiceResponseDto GetInvoice(long invoiceId)
        {
            var invoice = _invoiceRepository.GetInvoiceWithDetails(invoiceId);

            if (invoice == null)
                throw new Exception("Invoice not found.");

            var header = _mapper.Map<InvoiceHeaderDto>(invoice);

            var details = _mapper.Map<List<InvoiceDetailDto>>(invoice.InvoiceDetails);

            return new InvoiceResponseDto
            {
                Header = header,
                Details = details
            };
        }

        #endregion
    }
}