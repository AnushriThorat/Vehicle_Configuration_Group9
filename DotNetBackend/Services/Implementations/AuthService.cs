using BCrypt.Net;
using DotNetBackend.DTOs;
using DotNetBackend.Helpers;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class AuthService : IAuthService
    {
        private readonly IUserRepository _userRepository;
        private readonly JwtService _jwtService;

        public AuthService(IUserRepository userRepository,JwtService jwtService)
        {
            _userRepository = userRepository;
            _jwtService = jwtService;
        }

        public LoginResponseDto Login(LoginRequestDto request)
        {
            var user = _userRepository.GetUserByUsername(request.Username);

            if (user == null)
            {
                throw new Exception("Invalid Username");
            }

            bool isValid = BCrypt.Net.BCrypt.Verify(
                request.Password,
                user.Password
            );

            if (!isValid)
            {
                throw new Exception("Invalid Password");
            }

            return new LoginResponseDto
            {
                Username = user.Username,
                Token = _jwtService.GenerateToken(user)
            };
        }

        public string Register(RegisterDto request)
        {
            var user = new User
            {
                Username = request.Username,
                Password = BCrypt.Net.BCrypt.HashPassword(request.Password),
                CompanyName = request.CompanyName,
                CompanyEmail = request.CompanyEmail
            };

            _userRepository.AddUser(user);

            _userRepository.Save();

            return "Registration Successful";
        }
    }
}