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

        public List<MfgMaster> GetBySegment(int segmentId)
        {
            return _context.MfgMasters
                .Where(x => x.SegId == segmentId)
                .ToList();
        }
    }
}