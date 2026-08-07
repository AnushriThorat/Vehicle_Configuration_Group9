using DotNetBackend.Services.Generic;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers.Generic
{
    [ApiController]
    [Authorize]
    public abstract class GenericController<TDto> : ControllerBase
        where TDto : class
    {
        protected readonly IGenericService<TDto> _service;

        protected GenericController(IGenericService<TDto> service)
        {
            _service = service;
        }

        [HttpGet]
        public virtual IActionResult GetAll()
        {
            return Ok(_service.GetAll());
        }

        [HttpGet("{id}")]
        public virtual IActionResult GetById(int id)
        {
            return Ok(_service.GetById(id));
        }

        [HttpPost]
        public virtual IActionResult Add([FromBody] TDto dto)
        {
            return Ok(_service.Add(dto));
        }

        [HttpPut("{id}")]
        public virtual IActionResult Update(int id, [FromBody] TDto dto)
        {
            return Ok(_service.Update(id, dto));
        }

        [HttpDelete("{id}")]
        public virtual IActionResult Delete(int id)
        {
            _service.Delete(id);

            return Ok("Deleted Successfully");
        }
    }
}