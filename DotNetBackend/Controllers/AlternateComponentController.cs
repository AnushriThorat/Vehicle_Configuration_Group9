using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [Route("api/alternate-component")]
    public class AlternateComponentController
        : GenericController<AlternateComponentMasterDto>
    {
        private readonly IAlternateComponentService _service;

        public AlternateComponentController(
            IAlternateComponentService service)
            : base(service)
        {
            _service = service;
        }

        [HttpGet("model/{modelId}")]
        public IActionResult GetByModel(int modelId)
        {
            return Ok(_service.GetByModel(modelId));
        }

        [HttpGet("component/{componentId}")]
        public IActionResult GetByComponent(int componentId)
        {
            return Ok(_service.GetByComponent(componentId));
        }
    }
}