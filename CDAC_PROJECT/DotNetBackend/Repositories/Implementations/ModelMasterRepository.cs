using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class ModelMasterRepository
        : GenericRepository<ModelMaster>,
          IModelMasterRepository
    {
        public ModelMasterRepository(
            ApplicationDbContext context)
            : base(context)
        {

        }

        public List<ModelMaster> GetWithRelations()
        {
            return _context.ModelMasters
                .Include(x => x.Seg)
                .Include(x => x.Mfg)
                .ToList();
        }

        public ModelMaster? GetWithRelations(int id)
        {
            return _context.ModelMasters
                .Include(x => x.Seg)
                .Include(x => x.Mfg)
                .FirstOrDefault(x => x.ModelId == id);
        }

        public List<ModelMaster> GetByManufacturer(int manufacturerId)
        {
            return _context.ModelMasters
                .Include(x => x.Mfg)
                .Include(x => x.Seg)
                .Where(x => x.MfgId == manufacturerId)
                .ToList();
        }
    }
}