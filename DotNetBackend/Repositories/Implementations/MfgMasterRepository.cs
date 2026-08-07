using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class MfgMasterRepository :
        GenericRepository<MfgMaster>,
        IMfgMasterRepository
    {
        public MfgMasterRepository(
            ApplicationDbContext context)
            : base(context)
        {

        }

        public List<MfgMaster> GetWithSegment()
        {
            return _context.MfgMasters
                           .Include(x => x.Seg)
                           .ToList();
        }
    }
}