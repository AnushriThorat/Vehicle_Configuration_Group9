using System.Linq.Expressions;

namespace Vehiclecfg_group9.Repository
{
    public interface IGenericRepository<T> where T : class
    {

        // Get all records
        Task<IEnumerable<T>> GetAllAsync(
            params Expression<Func<T, object>>[] includes);



        // Get record by id
        Task<T?> GetByIdAsync(
            int id,
            params Expression<Func<T, object>>[] includes);



        // Add record
        Task<T> AddAsync(T entity);



        // Update record
        Task<T> UpdateAsync(T entity);



        // Delete record
        Task<T?> DeleteAsync(int id);

    }
}