using DotNetBackend.DTOs;
using DotNetBackend.Services.Generic;

namespace DotNetBackend.Services.Interfaces
{
    public interface IUserService
        : IGenericService<UserDto>
    {
    }
}