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

        public AuthService(
            IUserRepository userRepository,
            JwtService jwtService)
        {
            _userRepository = userRepository;
            _jwtService = jwtService;
        }

        // =====================================================
        // LOGIN
        // =====================================================

        public LoginResponseDto Login(LoginRequestDto request)
        {
            if (request == null)
            {
                throw new Exception("Invalid login request.");
            }

            if (string.IsNullOrWhiteSpace(request.Username))
            {
                throw new Exception("Username is required.");
            }

            if (string.IsNullOrWhiteSpace(request.Password))
            {
                throw new Exception("Password is required.");
            }

            var user =
                _userRepository.GetUserByUsername(
                    request.Username
                );

            if (user == null)
            {
                throw new Exception("Invalid Username");
            }

            bool isValid =
                BCrypt.Net.BCrypt.Verify(
                    request.Password,
                    user.Password
                );

            if (!isValid)
            {
                throw new Exception("Invalid Password");
            }

            return new LoginResponseDto
            {
                Id = user.Id,

                Username = user.Username,

                Token =
                    _jwtService.GenerateToken(user)
            };
        }


        // =====================================================
        // REGISTER
        // =====================================================

        public string Register(RegisterDto request)
        {
            if (request == null)
            {
                throw new Exception(
                    "Invalid registration request."
                );
            }

            if (string.IsNullOrWhiteSpace(request.Username))
            {
                throw new Exception(
                    "Username is required."
                );
            }

            if (string.IsNullOrWhiteSpace(request.Password))
            {
                throw new Exception(
                    "Password is required."
                );
            }

            if (string.IsNullOrWhiteSpace(request.CompanyName))
            {
                throw new Exception(
                    "Company name is required."
                );
            }

            if (string.IsNullOrWhiteSpace(request.CompanyEmail))
            {
                throw new Exception(
                    "Company email is required."
                );
            }


            // Check duplicate username
            var existingUser =
                _userRepository.GetUserByUsername(
                    request.Username
                );

            if (existingUser != null)
            {
                throw new Exception(
                    "Username already exists."
                );
            }


            var user = new User
            {
                Id = request.Id,

                Username = request.Username,

                Password =
                    BCrypt.Net.BCrypt.HashPassword(
                        request.Password
                    ),

                CompanyName =
                    request.CompanyName,

                CompanyEmail =
                    request.CompanyEmail
            };


            _userRepository.AddUser(user);

            _userRepository.Save();


            return "Registration Successful";
        }
    }
}