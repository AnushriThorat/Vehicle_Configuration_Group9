using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/mfg")]
    public class MfgMasterController : GenericController<MfgMasterDto>
    {
        private readonly IMfgMasterService _service;

        public MfgMasterController(IMfgMasterService service)
            : base(service)
        {
            _service = service;
        }

        [HttpGet("segment/{segmentId}")]
        public IActionResult GetBySegment(int segmentId)
        {
            return Ok(_service.GetBySegment(segmentId));
        }
    }
}