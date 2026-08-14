using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class VehicleDetailController : ControllerBase
    {
        private readonly VehicleDetailService _service;

        public VehicleDetailController(VehicleDetailService service)
        {
            _service = service;
        }

        // GET: api/VehicleDetail
        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var data = await _service.GetAllAsync();

            var result = data.Select(v => new VehicleDetailsResponseDto
            {
                ModelId = v.ModelId,
                MfgId = v.Model?.MfgId ?? 0,
                SegId = v.Model?.SegId ?? 0
            }).ToList();

            return Ok(result);
        }

        // GET: api/VehicleDetail/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var data = await _service.GetByIdAsync(id);

            if (data == null)
                return NotFound();

            var result = new VehicleDetailsResponseDto
            {
                ModelId = data.ModelId,
                MfgId = data.Model?.MfgId ?? 0,
                SegId = data.Model?.SegId ?? 0
            };

            return Ok(result);
        }

        // POST: api/VehicleDetail
        [HttpPost]
        public async Task<IActionResult> Add(VehicleDetailRequestDto dto)
        {
            var vehicleDetail = new VehicleDetail
            {
                ModelId = dto.ModelId,
                CompId = dto.CompId,
                CompType = dto.CompType,
                IsConfigurable = dto.IsConfigurable
            };

            var result = await _service.AddAsync(vehicleDetail);

            return CreatedAtAction(nameof(GetById),
                new { id = result.ConfiId },
                result);
        }

        // PUT: api/VehicleDetail
        // PUT: api/VehicleDetail
        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, VehicleDetailRequestDto dto)
        {
            var vehicleDetail = new VehicleDetail
            {
                ConfiId = id,
                ModelId = dto.ModelId,
                CompId = dto.CompId,
                CompType = dto.CompType,
                IsConfigurable = dto.IsConfigurable
            };

            var result = await _service.UpdateAsync(vehicleDetail);

            return Ok(result);
        }

        // DELETE: api/VehicleDetail/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            var result = await _service.DeleteAsync(id);

            if (result == null)
                return NotFound();

            return Ok(new
            {
                Message = "Vehicle detail deleted successfully",
                DeletedId = result.ConfiId
            });
        }
    }
}