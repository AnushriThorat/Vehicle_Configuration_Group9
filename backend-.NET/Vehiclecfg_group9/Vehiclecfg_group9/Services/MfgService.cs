using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Services
{
    public class MfgService
    {

        private readonly IGenericRepository<MfgMaster> _repository;


        public MfgService(
            IGenericRepository<MfgMaster> repository)
        {
            _repository = repository;
        }



        // Create Manufacturer
        public async Task<MfgMaster> SaveManufacturer(
            MfgMaster manufacturer)
        {
            return await _repository.AddAsync(manufacturer);
        }



        // Get All Manufacturers
        public async Task<IEnumerable<MfgMaster>> GetAllManufacturers()
        {
            return await _repository.GetAllAsync();
        }



        // Get Manufacturer By Id
        public async Task<MfgMaster?> GetManufacturerById(int id)
        {
            return await _repository.GetByIdAsync(id);
        }



        // Get Manufacturer By Segment
        public async Task<IEnumerable<MfgMaster>> GetManufacturersBySegment(
            int segmentId)
        {

            var manufacturers = await _repository.GetAllAsync();


            return manufacturers
                .Where(x => x.SegId == segmentId);
        }



        // Update Manufacturer
        public async Task<MfgMaster> UpdateManufacturer(
            MfgMaster manufacturer)
        {

            var existing = await _repository
                .GetByIdAsync(manufacturer.MfgId);


            if (existing == null)
            {
                throw new Exception(
                    "Manufacturer not found with ID : "
                    + manufacturer.MfgId
                );
            }


            return await _repository
                .UpdateAsync(manufacturer);
        }



        // Delete Manufacturer
        public async Task DeleteManufacturer(int id)
        {

            var existing = await _repository
                .GetByIdAsync(id);


            if (existing == null)
            {
                throw new Exception(
                    "Manufacturer not found with ID : "
                    + id
                );
            }


            await _repository.DeleteAsync(id);
        }

    }
}