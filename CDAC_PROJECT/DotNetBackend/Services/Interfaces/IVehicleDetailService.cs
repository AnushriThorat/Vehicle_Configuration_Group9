using DotNetBackend.DTOs;
using DotNetBackend.Services.Generic;

namespace DotNetBackend.Services.Interfaces
{
    public interface IVehicleDetailService
        : IGenericService<VehicleDetailDto>
    {
        List<VehicleDetailDto> GetByModel(int modelId);

        List<VehicleDetailDto> GetConfigurable(int modelId);

        VehicleDetailsResponseDto GetVehicleDetails(int modelId);
    }
}