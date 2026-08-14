using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Services
{
    public class VehicleDetailService
    {
        private readonly IGenericRepository<VehicleDetail> _repository;

        public VehicleDetailService(IGenericRepository<VehicleDetail> repository)
        {
            _repository = repository;
        }

        public async Task<IEnumerable<VehicleDetail>> GetAllAsync()
        {
            return await _repository.GetAllAsync();
        }

        public async Task<VehicleDetail?> GetByIdAsync(int id)
        {
            return await _repository.GetByIdAsync(id);
        }

        public async Task<VehicleDetail> AddAsync(VehicleDetail vehicleDetail)
        {
            return await _repository.AddAsync(vehicleDetail);
        }

        public async Task<VehicleDetail> UpdateAsync(VehicleDetail vehicleDetail)
        {
            return await _repository.UpdateAsync(vehicleDetail);
        }

        public async Task<VehicleDetail?> DeleteAsync(int id)
        {
            return await _repository.DeleteAsync(id);
        }

        internal async Task AddAsync(VehicleDetailRequestDto dto)
        {
            throw new NotImplementedException();
        }
    }
}