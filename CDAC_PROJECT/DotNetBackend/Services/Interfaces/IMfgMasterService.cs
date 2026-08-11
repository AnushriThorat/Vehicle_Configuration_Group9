using DotNetBackend.DTOs;
using DotNetBackend.Services.Generic;

namespace DotNetBackend.Services.Interfaces
{
    public interface IMfgMasterService : IGenericService<MfgMasterDto>
    {
        List<MfgMasterDto> GetBySegment(int segmentId);
    }
}