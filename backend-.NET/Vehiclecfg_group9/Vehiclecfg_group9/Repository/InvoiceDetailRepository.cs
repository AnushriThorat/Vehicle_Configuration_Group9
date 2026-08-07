using Microsoft.EntityFrameworkCore;
using Vehiclecfg_group9.data;
using Vehiclecfg_group9.Models;

namespace Vehiclecfg_group9.Repository
{
    public class InvoiceDetailRepository
        : GenericRepository<InvoiceDetail>,
          IInvoiceDetailRepository
    {
        private readonly VehicleCfgContext _context;

        public InvoiceDetailRepository(VehicleCfgContext context)
            : base(context)
        {
            _context = context;
        }

        public async Task<IEnumerable<InvoiceDetail>> GetByInvoiceIdAsync(long invoiceId)
        {
            return await _context.InvoiceDetails
                .Include(x => x.Comp)
                .Include(x => x.AltComp)
                .Include(x => x.Model)
                .Include(x => x.Inv)
                .Where(x => x.InvId == invoiceId)
                .ToListAsync();
        }
    }
}