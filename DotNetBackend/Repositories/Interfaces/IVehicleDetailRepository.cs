using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IVehicleDetailRepository
        : IGenericRepository<VehicleDetail>
    {
        List<VehicleDetail> GetByModel(int modelId);

        List<VehicleDetail> GetConfigurable(int modelId);

        VehicleDetail? GetDetails(int id);
    }
}