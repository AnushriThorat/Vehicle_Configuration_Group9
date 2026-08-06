using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class UserRepository : IUserRepository
    {
        private readonly ApplicationDbContext _context;

        public UserRepository(ApplicationDbContext context)
        {
            _context = context;
        }

        public User? GetUserByUsername(string username)
        {
            return _context.Users
                           .FirstOrDefault(u => u.Username == username);
        }

        public void AddUser(User user)
        {
            _context.Users.Add(user);
        }

        public void Save()
        {
            _context.SaveChanges();
        }
    }
}