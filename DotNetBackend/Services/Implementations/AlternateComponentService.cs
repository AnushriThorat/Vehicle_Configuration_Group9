using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class AlternateComponentService
        : GenericService<AlternateComponentMaster, AlternateComponentMasterDto>,
          IAlternateComponentService
    {
        private readonly IAlternateComponentRepository _repository;
        private readonly IMapper _mapper;

        public AlternateComponentService(
            IAlternateComponentRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        public List<AlternateComponentMasterDto> GetByModel(int modelId)
        {
            return _mapper.Map<List<AlternateComponentMasterDto>>(
                _repository.GetByModel(modelId));
        }

        public List<AlternateComponentMasterDto> GetByComponent(int componentId)
        {
            return _mapper.Map<List<AlternateComponentMasterDto>>(
                _repository.GetByComponent(componentId));
        }

        public override AlternateComponentMasterDto? GetById(int id)
        {
            var entity = _repository.GetDetails(id);

            if (entity == null)
                throw new Exception("Alternate Component not found.");

            return _mapper.Map<AlternateComponentMasterDto>(entity);
        }
    }
}