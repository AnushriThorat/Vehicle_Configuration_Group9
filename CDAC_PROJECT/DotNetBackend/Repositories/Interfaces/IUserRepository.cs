using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IUserRepository : IGenericRepository<User>
    {
        User? GetById(int id);

        User? GetUserByUsername(string username);

        void AddUser(User user);
    }
}