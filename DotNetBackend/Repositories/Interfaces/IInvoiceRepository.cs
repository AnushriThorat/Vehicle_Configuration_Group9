using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IInvoiceRepository
        : IGenericRepository<Invoice>
    {
        Invoice? GetInvoiceWithDetails(long invoiceId);

        void AddInvoice(Invoice invoice);
    }
}