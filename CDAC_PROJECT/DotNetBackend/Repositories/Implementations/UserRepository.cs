using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;

namespace DotNetBackend.Repositories.Implementations
{
    public class UserRepository
        : GenericRepository<User>,
          IUserRepository
    {
        public UserRepository(ApplicationDbContext context)
            : base(context)
        {
        }

        public User? GetById(int id)
        {
            return _context.Users
                .FirstOrDefault(x => x.Id == id);
        }

        public User? GetUserByUsername(string username)
        {
            return _context.Users
                .FirstOrDefault(
                    x => x.Username == username
                );
        }

        public void AddUser(User user)
        {
            _context.Users.Add(user);
        }
    }
}