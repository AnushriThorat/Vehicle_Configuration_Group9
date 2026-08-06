using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class InvoiceDetailRepository
        : GenericRepository<InvoiceDetail>,
          IInvoiceDetailRepository
    {
        public InvoiceDetailRepository(
            ApplicationDbContext context)
            : base(context)
        {
        }

        public List<InvoiceDetail> GetInvoiceDetails(long invoiceId)
        {
            return _context.InvoiceDetails
                .Include(x => x.Comp)
                .Include(x => x.AltComp)
                .Where(x => x.InvId == invoiceId)
                .ToList();
        }

        public void AddRange(List<InvoiceDetail> details)
        {
            _context.InvoiceDetails.AddRange(details);
        }
    }
}