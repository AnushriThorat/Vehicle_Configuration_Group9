using DotNetBackend.Data;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Repositories.Implementations
{
    public class VehicleDetailRepository :
        GenericRepository<VehicleDetail>,
        IVehicleDetailRepository
    {
        public VehicleDetailRepository(
            ApplicationDbContext context)
            : base(context)
        {
        }

        public List<VehicleDetail> GetByModel(int modelId)
        {
            return _context.VehicleDetails

                .Include(x => x.Model)
                    .ThenInclude(x => x.Mfg)

                .Include(x => x.Model)
                    .ThenInclude(x => x.Seg)

                .Include(x => x.Comp)

                .Where(x => x.ModelId == modelId)

                .ToList();
        }

        public List<VehicleDetail> GetConfigurable(int modelId)
        {
            return _context.VehicleDetails
                .Include(x => x.Model)
                .Include(x => x.Comp)
                .Where(x =>
                    x.ModelId == modelId &&
                    x.IsConfigurable == 1)
                .ToList();
        }

        public VehicleDetail? GetDetails(int id)
        {
            return _context.VehicleDetails
                .Include(x => x.Model)
                .Include(x => x.Comp)
                .FirstOrDefault(x => x.ConfiId == id);
        }
        
    }
}