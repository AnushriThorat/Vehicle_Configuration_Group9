using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class ModelMasterService
        : GenericService<ModelMaster, ModelMasterDto>,
          IModelMasterService
    {
        private readonly IModelMasterRepository _repository;
        private readonly IMapper _mapper;

        public ModelMasterService(
            IModelMasterRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        public override List<ModelMasterDto> GetAll()
        {
            var models = _repository.GetWithRelations();

            return _mapper.Map<List<ModelMasterDto>>(models);
        }

        public override ModelMasterDto? GetById(int id)
        {
            var model = _repository.GetWithRelations(id);

            if (model == null)
                throw new Exception("Model not found.");

            return _mapper.Map<ModelMasterDto>(model);
        }
    }
}