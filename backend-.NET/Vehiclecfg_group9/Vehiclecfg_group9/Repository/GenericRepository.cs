using Microsoft.EntityFrameworkCore;
using System.Linq.Expressions;
using Vehiclecfg_group9.data;


namespace Vehiclecfg_group9.Repository
{
    public class GenericRepository<T> : IGenericRepository<T>
        where T : class
    {

        private readonly VehicleCfgContext _context;

        private readonly DbSet<T> _dbSet;



        public GenericRepository(VehicleCfgContext context)
        {
            _context = context;
            _dbSet = _context.Set<T>();
        }



        // Get All with Include support
        public async Task<IEnumerable<T>> GetAllAsync(
            params Expression<Func<T, object>>[] includes)
        {

            IQueryable<T> query = _dbSet;


            foreach (var include in includes)
            {
                query = query.Include(include);
            }


            return await query.ToListAsync();
        }




        // Get By Id with Include support
        public async Task<T?> GetByIdAsync(
            int id,
            params Expression<Func<T, object>>[] includes)
        {

            IQueryable<T> query = _dbSet;


            foreach (var include in includes)
            {
                query = query.Include(include);
            }


            return await query.FirstOrDefaultAsync();
        }




        // Insert
        public async Task<T> AddAsync(T entity)
        {

            await _dbSet.AddAsync(entity);

            await _context.SaveChangesAsync();


            return entity;
        }




        // Update
        public async Task<T> UpdateAsync(T entity)
        {

            _dbSet.Update(entity);

            await _context.SaveChangesAsync();


            return entity;
        }




        // Delete
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