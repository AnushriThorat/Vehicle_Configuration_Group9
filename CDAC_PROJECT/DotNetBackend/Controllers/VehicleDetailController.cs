using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/vehicle")]
    public class VehicleDetailController
        : GenericController<VehicleDetailDto>
    {
        private readonly IVehicleDetailService _service;

        public VehicleDetailController(
            IVehicleDetailService service)
            : base(service)
        {
            _service = service;
        }

        // ==========================================
        // GET VEHICLE DETAILS
        // Returns complete vehicle information
        // ==========================================
        [HttpGet("model/{modelId}")]
        public IActionResult GetVehicleDetails(int modelId)
        {
            var result = _service.GetVehicleDetails(modelId);

            return Ok(result);
        }

        // ==========================================
        // GET CONFIGURABLE COMPONENTS
        // ==========================================
        [HttpGet("configurable/{modelId}")]
        public IActionResult GetConfigurable(int modelId)
        {
            var result = _service.GetConfigurable(modelId);

            return Ok(result);
        }
    }
}