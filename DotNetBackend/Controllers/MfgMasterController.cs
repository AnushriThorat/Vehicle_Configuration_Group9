using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [Route("api/mfg")]
    public class MfgMasterController
        : GenericController<MfgMasterDto>
    {
        public MfgMasterController(
            IMfgMasterService service)
            : base(service)
        {

        }
    }
}