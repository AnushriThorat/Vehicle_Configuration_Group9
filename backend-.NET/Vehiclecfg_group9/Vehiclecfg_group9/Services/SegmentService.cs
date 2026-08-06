using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Services
{
    public class SegmentService
    {
        private readonly IGenericRepository<SegmentMaster> _repo;


        public SegmentService(
            IGenericRepository<SegmentMaster> repo)
        {
            _repo = repo;
        }


        public async Task<IEnumerable<SegmentMaster>> GetAllAsync()
        {
            var segments = await _repo.GetAllAsync();

            return segments;
        }


        public async Task<SegmentMaster?> GetByIdAsync(int id)
        {
            var segment = await _repo.GetByIdAsync(id);

            return segment;
        }


        public async Task<SegmentMaster> AddSegmentAsync(SegmentMaster segment)
        {
            return await _repo.AddAsync(segment);
        }


        public async Task<SegmentMaster?> UpdateSegmentAsync(
            int id,
            SegmentMaster segment)
        {
            var existing = await _repo.GetByIdAsync(id);

            if (existing == null)
                return null;


            existing.SegName = segment.SegName;
            existing.MinQty = segment.MinQty;


            return await _repo.UpdateAsync(existing);
        }


        public async Task<SegmentMaster?> DeleteSegmentAsync(int id)
        {
            var segment = await _repo.GetByIdAsync(id);

            if (segment == null)
                return null;


            return await _repo.DeleteAsync(id);
        }
    }
}