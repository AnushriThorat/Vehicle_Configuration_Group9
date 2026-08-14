using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IMfgMasterRepository : IGenericRepository<MfgMaster>
    {
        List<MfgMaster> GetBySegment(int segmentId);
    }
}