using Microsoft.AspNetCore.Mvc;
using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.DTO;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly UserService _userService;

        public UserController(UserService userService)
        {
            _userService = userService;
        }

        // ========================= REGISTER =========================

        [HttpPost("register")]
        public async Task<IActionResult> Register(RegisterRequestDTO dto)
        {
            var user = new User
            {
                Username = dto.Username,
                Password = dto.Password,
                CompanyName = dto.CompanyName,
                CompanyEmail = dto.CompanyEmail,
                RegistrationNo = dto.RegistrationNo,
                HoldingType = dto.HoldingType,
                Add1 = dto.Add1,
                Add2 = dto.Add2,
                City = dto.City,
                State = dto.State,
                Pin = dto.Pin,
                AuthName = dto.AuthName,
                Designation = dto.Designation,
                AuthTel = dto.AuthTel,
                Cell = dto.Cell,
                Phone = dto.Phone,
                Fax = dto.Fax,
                CompanyStNo = dto.CompanyStNo,
                CompanyVatNo = dto.CompanyVatNo,
                TaxPan = dto.TaxPan
            };

            var createdUser = await _userService.AddUserAsync(user);

            return Ok(createdUser);
        }

        // ========================= LOGIN =========================

        [HttpPost("login")]
        public async Task<IActionResult> Login(LoginRequestDTO dto)
        {
            var users = await _userService.GetAllUsersAsync();

            var user = users.FirstOrDefault(u =>
                u.Username == dto.Username &&
                u.Password == dto.Password);

            if (user == null)
            {
                return Unauthorized("Invalid Username or Password");
            }

            var response = new LoginResponseDTO
            {
                Id = user.Id,
                Username = user.Username,
                Token = "JWT_TOKEN"
            };

            return Ok(response);
        }

        // ========================= GET ALL =========================

        [HttpGet]
        public async Task<IActionResult> GetAllUsers()
        {
            var users = await _userService.GetAllUsersAsync();

            return Ok(users);
        }

        // ========================= GET BY ID =========================

        [HttpGet("{id}")]
        public async Task<IActionResult> GetUserById(int id)
        {
            var user = await _userService.GetUserByIdAsync(id);

            if (user == null)
            {
                return NotFound("User not found.");
            }

            return Ok(user);
        }

        // ========================= UPDATE =========================

        [HttpPut("{id}")]
        public async Task<IActionResult> UpdateUser(int id, RegisterRequestDTO dto)
        {
            var existingUser = await _userService.GetUserByIdAsync(id);

            if (existingUser == null)
            {
                return NotFound("User not found.");
            }

            existingUser.Username = dto.Username;
            existingUser.Password = dto.Password;
            existingUser.CompanyName = dto.CompanyName;
            existingUser.CompanyEmail = dto.CompanyEmail;
            existingUser.RegistrationNo = dto.RegistrationNo;
            existingUser.HoldingType = dto.HoldingType;
            existingUser.Add1 = dto.Add1;
            existingUser.Add2 = dto.Add2;
            existingUser.City = dto.City;
            existingUser.State = dto.State;
            existingUser.Pin = dto.Pin;
            existingUser.AuthName = dto.AuthName;
            existingUser.Designation = dto.Designation;
            existingUser.AuthTel = dto.AuthTel;
            existingUser.Cell = dto.Cell;
            existingUser.Phone = dto.Phone;
            existingUser.Fax = dto.Fax;
            existingUser.CompanyStNo = dto.CompanyStNo;
            existingUser.CompanyVatNo = dto.CompanyVatNo;
            existingUser.TaxPan = dto.TaxPan;

            var updatedUser = await _userService.UpdateUserAsync(existingUser);

            return Ok(updatedUser);
        }

        // ========================= DELETE =========================

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteUser(int id)
        {
            var deletedUser = await _userService.DeleteUserAsync(id);

            if (deletedUser == null)
            {
                return NotFound("User not found.");
            }

            return Ok(deletedUser);
        }
    }
}