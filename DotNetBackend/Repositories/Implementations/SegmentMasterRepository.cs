using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;

namespace DotNetBackend.Repositories.Implementations
{
    public class SegmentMasterRepository :
        GenericRepository<SegmentMaster>,
        ISegmentMasterRepository
    {
        public SegmentMasterRepository(
            ApplicationDbContext context)
            : base(context)
        {

        }
    }
}