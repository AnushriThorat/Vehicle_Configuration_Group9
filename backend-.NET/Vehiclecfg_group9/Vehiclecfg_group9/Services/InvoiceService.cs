using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Services
{
    public class InvoiceService : IInvoiceService
    {
        private readonly IGenericRepository<Invoice> _invoiceRepository;

        public InvoiceService(
            IGenericRepository<Invoice> invoiceRepository)
        {
            _invoiceRepository = invoiceRepository;
        }

        // GET ALL INVOICES
        public async Task<IEnumerable<InvoiceResponseDto>>
            GetAllInvoicesAsync()
        {
            var invoices = await _invoiceRepository.GetAllAsync(
                i => i.IdNavigation,
                i => i.Model
            );

            return invoices.Select(MapToResponseDto).ToList();
        }

        // GET INVOICE BY ID
        public async Task<InvoiceResponseDto?>
            GetInvoiceByIdAsync(long invoiceId)
        {
            /*
             * InvId is long in Invoice model.
             * Your GenericRepository accepts int,
             * therefore we find it from GetAllAsync().
             */
            var invoices = await _invoiceRepository.GetAllAsync(
                i => i.IdNavigation,
                i => i.Model
            );

            var invoice = invoices.FirstOrDefault(
                i => i.InvId == invoiceId
            );

            if (invoice == null)
            {
                return null;
            }

            return MapToResponseDto(invoice);
        }

        // ADD INVOICE
        public async Task<InvoiceResponseDto>
            AddInvoiceAsync(InvoiceCreateDto invoiceDto)
        {
            var invoice = new Invoice
            {
                InvDate = invoiceDto.InvDate,
                NetAmt = invoiceDto.NetAmt,
                Tax = invoiceDto.Tax,
                TotalAmt = invoiceDto.TotalAmt,
                ModelId = invoiceDto.ModelId,
                Id = invoiceDto.Id
            };

            var savedInvoice =
                await _invoiceRepository.AddAsync(invoice);

            return MapToResponseDto(savedInvoice);
        }

        // UPDATE INVOICE
        public async Task<InvoiceResponseDto?>
            UpdateInvoiceAsync(
                long invoiceId,
                InvoiceCreateDto invoiceDto)
        {
            var invoices = await _invoiceRepository.GetAllAsync();

            var invoice = invoices.FirstOrDefault(
                i => i.InvId == invoiceId
            );

            if (invoice == null)
            {
                return null;
            }

            invoice.InvDate = invoiceDto.InvDate;
            invoice.NetAmt = invoiceDto.NetAmt;
            invoice.Tax = invoiceDto.Tax;
            invoice.TotalAmt = invoiceDto.TotalAmt;
            invoice.ModelId = invoiceDto.ModelId;
            invoice.Id = invoiceDto.Id;

            var updatedInvoice =
                await _invoiceRepository.UpdateAsync(invoice);

            return MapToResponseDto(updatedInvoice);
        }

        // DELETE INVOICE
        public async Task<bool>
            DeleteInvoiceAsync(long invoiceId)
        {
            /*
             * Because GenericRepository.DeleteAsync()
             * accepts int while InvId is long,
             * we first check whether the invoice exists.
             */

            var invoices = await _invoiceRepository.GetAllAsync();

            var invoice = invoices.FirstOrDefault(
                i => i.InvId == invoiceId
            );

            if (invoice == null)
            {
                return false;
            }

            /*
             * Your current GenericRepository.DeleteAsync()
             * accepts int.
             */
            await _invoiceRepository.DeleteAsync(
                Convert.ToInt32(invoiceId)
            );

            return true;
        }

        // ENTITY -> DTO
        private static InvoiceResponseDto
            MapToResponseDto(Invoice invoice)
        {
            return new InvoiceResponseDto
            {
                InvId = invoice.InvId,
                InvDate = invoice.InvDate,
                NetAmt = invoice.NetAmt,
                Tax = invoice.Tax,
                TotalAmt = invoice.TotalAmt,
                ModelId = invoice.ModelId,
                Id = invoice.Id
            };
        }
    }
}