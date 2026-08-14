using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/model")]
    public class ModelMasterController
        : GenericController<ModelMasterDto>
    {
        private readonly IModelMasterService _service;

        public ModelMasterController(
            IModelMasterService service)
            : base(service)
        {
            _service = service;
        }

        [HttpGet("manufacturer/{manufacturerId}")]
        public IActionResult GetByManufacturer(int manufacturerId)
        {
            return Ok(_service.GetByManufacturer(manufacturerId));
        }
    }
}