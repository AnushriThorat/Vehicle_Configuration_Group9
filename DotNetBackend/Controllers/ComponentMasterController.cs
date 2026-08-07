using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [Route("api/component")]
    public class ComponentMasterController :
        GenericController<ComponentMasterDto>
    {
        public ComponentMasterController(
            IComponentMasterService service)
            : base(service)
        {

        }
    }
}