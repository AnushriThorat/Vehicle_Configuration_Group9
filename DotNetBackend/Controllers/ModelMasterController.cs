using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [Route("api/model")]
    public class ModelMasterController
        : GenericController<ModelMasterDto>
    {
        public ModelMasterController(
            IModelMasterService service)
            : base(service)
        {

        }
    }
}