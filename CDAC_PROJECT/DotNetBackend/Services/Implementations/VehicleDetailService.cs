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

        // =========================================================
        // GET ALL VEHICLE DETAILS BY MODEL
        // =========================================================
        public List<VehicleDetailDto> GetByModel(int modelId)
        {
            var entities = _repository.GetByModel(modelId);

            return _mapper.Map<List<VehicleDetailDto>>(entities);
        }

        // =========================================================
        // GET CONFIGURABLE VEHICLE DETAILS
        // =========================================================
        public List<VehicleDetailDto> GetConfigurable(int modelId)
        {
            var entities = _repository.GetConfigurable(modelId);

            return _mapper.Map<List<VehicleDetailDto>>(entities);
        }

        // =========================================================
        // GET VEHICLE DETAIL BY CONFIGURATION ID
        // =========================================================
        public override VehicleDetailDto? GetById(int id)
        {
            var entity = _repository.GetDetails(id);

            if (entity == null)
            {
                throw new Exception(
                    "Vehicle configuration not found."
                );
            }

            return _mapper.Map<VehicleDetailDto>(entity);
        }

        // =========================================================
        // GET COMPLETE VEHICLE DETAILS
        //
        // This endpoint returns the structure expected by React:
        //
        // {
        //     modelId,
        //     modelName,
        //     basePrice,
        //     imagePath,
        //     coreComponents,
        //     interiorComponents,
        //     exteriorComponents,
        //     standardComponents
        // }
        // =========================================================
        public VehicleDetailsResponseDto GetVehicleDetails(int modelId)
        {
            var vehicleDetails = _repository.GetByModel(modelId);

            if (vehicleDetails == null || !vehicleDetails.Any())
            {
                throw new Exception(
                    "Vehicle not found for the selected model."
                );
            }

            var first = vehicleDetails.First();

            // =====================================================
            // BASIC MODEL INFORMATION
            // =====================================================

            var response = new VehicleDetailsResponseDto
            {
                ModelId = first.ModelId,

                ModelName = first.Model?.ModelName,

                MfgName = first.Model?.Mfg?.MfgName,

                SegmentName = first.Model?.Seg?.SegName,

                BasePrice = first.Model?.BasePrice ?? 0,

                ImagePath = first.Model?.ImagePath
            };

            // =====================================================
            // CORE COMPONENTS
            // CompType = C
            // =====================================================

            response.CoreComponents = vehicleDetails
                .Where(x =>
                    !string.IsNullOrWhiteSpace(x.CompType) &&
                    x.CompType.Trim().ToUpperInvariant() == "C" &&
                    x.Comp != null)
                .GroupBy(x => x.CompId)
                .Select(group => new ComponentMasterDto
                {
                    CompId = group.Key,

                    CompName = group
                        .First()
                        .Comp
                        ?.CompName ?? string.Empty
                })
                .ToList();

            // =====================================================
            // INTERIOR COMPONENTS
            // CompType = I
            // =====================================================

            response.InteriorComponents = vehicleDetails
                .Where(x =>
                    !string.IsNullOrWhiteSpace(x.CompType) &&
                    x.CompType.Trim().ToUpperInvariant() == "I" &&
                    x.Comp != null)
                .GroupBy(x => x.CompId)
                .Select(group => new ComponentMasterDto
                {
                    CompId = group.Key,

                    CompName = group
                        .First()
                        .Comp
                        ?.CompName ?? string.Empty
                })
                .ToList();

            // =====================================================
            // EXTERIOR COMPONENTS
            // CompType = E
            // =====================================================

            response.ExteriorComponents = vehicleDetails
                .Where(x =>
                    !string.IsNullOrWhiteSpace(x.CompType) &&
                    x.CompType.Trim().ToUpperInvariant() == "E" &&
                    x.Comp != null)
                .GroupBy(x => x.CompId)
                .Select(group => new ComponentMasterDto
                {
                    CompId = group.Key,

                    CompName = group
                        .First()
                        .Comp
                        ?.CompName ?? string.Empty
                })
                .ToList();

            // =====================================================
            // STANDARD COMPONENTS
            // CompType = S
            // =====================================================

            response.StandardComponents = vehicleDetails
                .Where(x =>
                    !string.IsNullOrWhiteSpace(x.CompType) &&
                    x.CompType.Trim().ToUpperInvariant() == "S" &&
                    x.Comp != null)
                .GroupBy(x => x.CompId)
                .Select(group => new ComponentMasterDto
                {
                    CompId = group.Key,

                    CompName = group
                        .First()
                        .Comp
                        ?.CompName ?? string.Empty
                })
                .ToList();

            return response;
        }
    }
}