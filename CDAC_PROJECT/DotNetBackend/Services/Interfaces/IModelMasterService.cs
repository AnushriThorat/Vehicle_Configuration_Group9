using DotNetBackend.DTOs;
using DotNetBackend.Services.Generic;

namespace DotNetBackend.Services.Interfaces
{
    public interface IModelMasterService : IGenericService<ModelMasterDto>
    {
        List<ModelMasterDto> GetByManufacturer(int manufacturerId);
    }
}