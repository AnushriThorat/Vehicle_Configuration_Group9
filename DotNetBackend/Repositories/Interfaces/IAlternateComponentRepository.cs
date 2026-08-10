using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;

namespace DotNetBackend.Repositories.Interfaces
{
    public interface IAlternateComponentRepository
        : IGenericRepository<AlternateComponentMaster>
    {
        List<AlternateComponentMaster> GetByModel(int modelId);

        List<AlternateComponentMaster> GetByComponent(int componentId);

        AlternateComponentMaster? GetDetails(int id);
    }
}