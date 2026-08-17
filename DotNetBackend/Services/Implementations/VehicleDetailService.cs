using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class VehicleDetailService
        : GenericService<VehicleDetail, VehicleDetailDto>,
          IVehicleDetailService
    {
        private readonly IVehicleDetailRepository _repository;
        private readonly IMapper _mapper;

        public VehicleDetailService(
            IVehicleDetailRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        public List<VehicleDetailDto> GetByModel(int modelId)
        {
            return _mapper.Map<List<VehicleDetailDto>>(
                _repository.GetByModel(modelId));
        }

        public List<VehicleDetailDto> GetConfigurable(int modelId)
        {
            return _mapper.Map<List<VehicleDetailDto>>(
                _repository.GetConfigurable(modelId));
        }

        public override VehicleDetailDto? GetById(int id)
        {
            var entity = _repository.GetDetails(id);

            if (entity == null)
                throw new Exception("Vehicle configuration not found.");

            return _mapper.Map<VehicleDetailDto>(entity);
        }
    }
}