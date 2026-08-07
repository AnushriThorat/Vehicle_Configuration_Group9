using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Services
{
    public class InvoiceDetailService
    {
        private readonly IInvoiceDetailRepository _repository;

        public InvoiceDetailService(IInvoiceDetailRepository repository)
        {
            _repository = repository;
        }

        public async Task<IEnumerable<InvoiceDetail>> GetAllAsync()
        {
            return await _repository.GetAllAsync(
                x => x.Comp,
                x => x.AltComp,
                x => x.Model,
                x => x.Inv);
        }

        public async Task<InvoiceDetail> AddAsync(InvoiceDetail detail)
        {
            return await _repository.AddAsync(detail);
        }

        public async Task<InvoiceDetail> UpdateAsync(InvoiceDetail detail)
        {
            return await _repository.UpdateAsync(detail);
        }

        public async Task<InvoiceDetail?> DeleteAsync(int id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<IEnumerable<InvoiceDetail>> GetInvoiceDetails(long invoiceId)
        {
            return await _repository.GetByInvoiceIdAsync(invoiceId);
        }
    }
}