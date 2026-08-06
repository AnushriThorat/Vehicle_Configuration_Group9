using Microsoft.EntityFrameworkCore;
using Vehiclecfg_group9.data;

namespace Vehiclecfg_group9.Repository
{
    public class GenericRepository<T> : IGenericRepository<T> where T : class
    {
        private readonly VehicleCfgContext _context;
        private readonly DbSet<T> _dbSet;


        public GenericRepository(VehicleCfgContext context)
        {
            _context = context;
            _dbSet = _context.Set<T>();
        }


        public async Task<IEnumerable<T>> GetAllAsync()
        {
            return await _dbSet.ToListAsync();
        }


        public async Task<T?> GetByIdAsync(int id)
        {
            return await _dbSet.FindAsync(id);
        }


        public async Task<T> AddAsync(T entity)
        {
            await _dbSet.AddAsync(entity);
            await _context.SaveChangesAsync();

            return entity;
        }


        public async Task<T> UpdateAsync(T entity)
        {
            _dbSet.Update(entity);
            await _context.SaveChangesAsync();

            return entity;
        }


        public async Task<T?> DeleteAsync(int id)
        {
            var entity = await _dbSet.FindAsync(id);

            if (entity == null)
            {
                return null;
            }

            _dbSet.Remove(entity);
            await _context.SaveChangesAsync();

            return entity;
        }
    }
}