using Vehiclecfg_group9.Models;

namespace Vehiclecfg_group9.Repository
{
    public interface IInvoiceDetailRepository
        : IGenericRepository<InvoiceDetail>
    {
        Task<IEnumerable<InvoiceDetail>> GetByInvoiceIdAsync(long invoiceId);
    }
}