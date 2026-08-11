using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class UserService
        : GenericService<User, UserDto>,
          IUserService
    {
        private readonly IUserRepository _repository;
        private readonly IMapper _mapper;

        public UserService(
            IUserRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        // =============================================
        // GET USER BY ID
        // =============================================

        public override UserDto? GetById(int id)
        {
            var user = _repository.GetById(id);

            if (user == null)
            {
                throw new Exception(
                    "User not found."
                );
            }

            return _mapper.Map<UserDto>(user);
        }
    }
}