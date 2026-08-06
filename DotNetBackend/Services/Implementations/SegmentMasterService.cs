using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class SegmentMasterService
        : GenericService<SegmentMaster, SegmentMasterDto>,
          ISegmentMasterService
    {
        public SegmentMasterService(
            ISegmentMasterRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {

        }
    }
}