using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class InvoiceRepository
        : GenericRepository<Invoice>,
          IInvoiceRepository
    {
        public InvoiceRepository(
            ApplicationDbContext context)
            : base(context)
        {
        }

        public void AddInvoice(Invoice invoice)
        {
            _context.Invoices.Add(invoice);
        }

        public Invoice? GetInvoiceWithDetails(long invoiceId)
        {
            return _context.Invoices
                .Include(i => i.IdNavigation)
                .Include(i => i.Model)
                .Include(i => i.InvoiceDetails)
                    .ThenInclude(d => d.Comp)
                .Include(i => i.InvoiceDetails)
                    .ThenInclude(d => d.AltComp)
                .FirstOrDefault(i => i.InvId == invoiceId);
        }
    }
}