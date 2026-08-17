using DotNetBackend.DTOs;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/auth")]
    public class AuthController : ControllerBase
    {
        private readonly IAuthService _authService;

        public AuthController(IAuthService authService)
        {
            _authService = authService;
        }

        [HttpPost("login")]
        [AllowAnonymous]
        public IActionResult Login(LoginRequestDto request)
        {
            var response = _authService.Login(request);

            return Ok(response);
        }

        [HttpPost("register")]
        [AllowAnonymous]
        public IActionResult Register(RegisterDto request)
        {
            var response = _authService.Register(request);

            return Ok(response);
        }
    }
}