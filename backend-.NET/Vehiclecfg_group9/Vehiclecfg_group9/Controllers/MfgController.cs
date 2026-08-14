using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;

namespace Vehiclecfg_group9.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class MfgController : ControllerBase
    {

        private readonly IGenericRepository<MfgMaster> _repo;


        public MfgController(IGenericRepository<MfgMaster> repo)
        {
            _repo = repo;
        }


        // POST: api/Mfg
        [HttpPost]
        public async Task<IActionResult> AddManufacturer(
            [FromBody] MfgMaster manufacturer)
        {
            var result = await _repo.AddAsync(manufacturer);

            return Ok(result);
        }



        // GET: api/Mfg
        [HttpGet]
        public async Task<IActionResult> GetAllManufacturers()
        {
            var result = await _repo.GetAllAsync();

            return Ok(result);
        }



        // GET: api/Mfg/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetManufacturerById(int id)
        {
            var result = await _repo.GetByIdAsync(id);


            if (result == null)
            {
                return NotFound(
                    "Manufacturer not found"
                );
            }


            return Ok(result);
        }



        // GET: api/Mfg/segment/2
        [HttpGet("segment/{segmentId}")]
        public async Task<IActionResult> GetManufacturersBySegment(
            int segmentId)
        {
            var result = await _repo.GetAllAsync();


            var manufacturers = result
                .Where(x => x.SegId == segmentId);


            return Ok(manufacturers);
        }



        // PUT: api/Mfg
        [HttpPut]
        public async Task<IActionResult> UpdateManufacturer(
            [FromBody] MfgMaster manufacturer)
        {

            var existing = await _repo
                .GetByIdAsync(manufacturer.MfgId);


            if (existing == null)
            {
                return NotFound(
                    "Manufacturer not found"
                );
            }


            var result = await _repo.UpdateAsync(manufacturer);


            return Ok(result);
        }



        // DELETE: api/Mfg/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteManufacturer(int id)
        {

            var existing = await _repo.GetByIdAsync(id);


            if (existing == null)
            {
                return NotFound(
                    "Manufacturer not found"
                );
            }


            await _repo.DeleteAsync(id);


            return Ok(new
            {
                message = "Manufacturer deleted successfully"
            });
        }

    }
}