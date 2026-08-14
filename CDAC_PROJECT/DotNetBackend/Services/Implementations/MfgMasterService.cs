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
        private readonly IMfgMasterRepository _repository;
        private readonly IMapper _mapper;

        public MfgMasterService(
            IMfgMasterRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        public List<MfgMasterDto> GetBySegment(int segmentId)
        {
            var manufacturers = _repository.GetBySegment(segmentId);

            return _mapper.Map<List<MfgMasterDto>>(manufacturers);
        }
    }
}