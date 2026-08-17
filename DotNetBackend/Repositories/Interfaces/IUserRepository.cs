using DotNetBackend.Models;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IUserRepository
    {
        User? GetUserByUsername(string username);

        void AddUser(User user);

        void Save();
    }
}