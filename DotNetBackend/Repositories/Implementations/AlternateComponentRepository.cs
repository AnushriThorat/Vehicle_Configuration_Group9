using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class AlternateComponentRepository
        : GenericRepository<AlternateComponentMaster>,
          IAlternateComponentRepository
    {
        public AlternateComponentRepository(
            ApplicationDbContext context)
            : base(context)
        {

        }

        public List<AlternateComponentMaster> GetByModel(int modelId)
        {
            return _context.AlternateComponentMasters
                .Include(x => x.Model)
                .Include(x => x.Comp)
                .Include(x => x.AltComp)
                .Where(x => x.ModelId == modelId)
                .ToList();
        }

        public List<AlternateComponentMaster> GetByComponent(int componentId)
        {
            return _context.AlternateComponentMasters
                .Include(x => x.Model)
                .Include(x => x.Comp)
                .Include(x => x.AltComp)
                .Where(x => x.CompId == componentId)
                .ToList();
        }

        public AlternateComponentMaster? GetDetails(int id)
        {
            return _context.AlternateComponentMasters
                .Include(x => x.Model)
                .Include(x => x.Comp)
                .Include(x => x.AltComp)
                .FirstOrDefault(x => x.AltId == id);
        }
    }
}