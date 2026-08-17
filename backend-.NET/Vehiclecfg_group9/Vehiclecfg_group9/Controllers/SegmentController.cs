using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9.Controllers
{
    [ApiController]
    [Route("api")]
    public class SegmentController : ControllerBase
    {
        private readonly SegmentService _service;

        public SegmentController(SegmentService service)
        {
            _service = service;
        }

        // GET api/getSegment
        [HttpGet("getSegment")]
        public async Task<IActionResult> GetAll()
        {
            var segments = await _service.GetAllAsync();
            return Ok(segments);
        }

        // POST api/saveSegment
        [HttpPost("saveSegment")]
        public async Task<IActionResult> SaveSegment([FromBody] SegmentMaster segment)
        {
            var savedSegment = await _service.AddSegmentAsync(segment);
            return Created("", savedSegment);
        }

        // PUT api/update/1
        [HttpPut("update/{id}")]
        public async Task<IActionResult> UpdateSegment(int id, [FromBody] SegmentMaster segment)
        {
            var updatedSegment = await _service.UpdateSegmentAsync(id, segment);
            return Ok(updatedSegment);
        }

        // DELETE api/delete/1
        [HttpDelete("delete/{id}")]
        public async Task<IActionResult> DeleteSegment(int id)
        {
            await _service.DeleteSegmentAsync(id);
            return NoContent();
        }
    }
}