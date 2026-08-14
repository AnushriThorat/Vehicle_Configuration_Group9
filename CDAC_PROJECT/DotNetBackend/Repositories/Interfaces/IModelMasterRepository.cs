using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IModelMasterRepository
        : IGenericRepository<ModelMaster>
    {
        List<ModelMaster> GetWithRelations();

        ModelMaster? GetWithRelations(int id);

        List<ModelMaster> GetByManufacturer(int manufacturerId);
    }
}