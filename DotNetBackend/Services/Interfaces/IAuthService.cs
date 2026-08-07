using DotNetBackend.DTOs;

namespace DotNetBackend.Services.Interfaces
{
    public interface IAuthService
    {
        LoginResponseDto Login(LoginRequestDto request);

        string Register(RegisterDto request);
    }
}