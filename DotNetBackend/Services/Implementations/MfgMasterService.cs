using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class MfgMasterService
        : GenericService<MfgMaster, MfgMasterDto>,
          IMfgMasterService
    {
        public MfgMasterService(
            IMfgMasterRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {

        }
    }
}