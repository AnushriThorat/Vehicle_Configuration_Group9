using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/users")]
    [Authorize]
    public class UserController : ControllerBase
    {
        private readonly IUserService _userService;

        public UserController(
            IUserService userService)
        {
            _userService = userService;
        }

        // =============================================
        // GET USER BY ID
        // GET /api/users/{id}
        // =============================================

        [HttpGet("{id:int}")]
        public IActionResult GetUser(int id)
        {
            try
            {
                var user = _userService.GetById(id);

                return Ok(user);
            }
            catch (Exception ex)
            {
                return NotFound(new
                {
                    Message = ex.Message
                });
            }
        }
    }
}