using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
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

        [HttpGet("model/{modelId}")]
        public IActionResult GetByModel(int modelId)
        {
            return Ok(_service.GetByModel(modelId));
        }

        [HttpGet("configurable/{modelId}")]
        public IActionResult GetConfigurable(int modelId)
        {
            return Ok(_service.GetConfigurable(modelId));
        }
    }
}