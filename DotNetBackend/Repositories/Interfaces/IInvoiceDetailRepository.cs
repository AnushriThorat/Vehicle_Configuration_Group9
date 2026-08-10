using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IInvoiceDetailRepository
        : IGenericRepository<InvoiceDetail>
    {
        List<InvoiceDetail> GetInvoiceDetails(long invoiceId);

        void AddRange(List<InvoiceDetail> details);
    }
}