using DotNetBackend.Controllers.Generic;
using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [Route("api/segment")]
    public class SegmentMasterController
        : GenericController<SegmentMasterDto>
    {
        public SegmentMasterController(
            ISegmentMasterService service)
            : base(service)
        {

        }
    }
}