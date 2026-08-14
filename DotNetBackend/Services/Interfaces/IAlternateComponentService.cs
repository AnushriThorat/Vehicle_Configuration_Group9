using DotNetBackend.DTOs;
using DotNetBackend.Services.Generic;

namespace DotNetBackend.Services.Interfaces
{
    public interface IAlternateComponentService
        : IGenericService<AlternateComponentMasterDto>
    {
        List<AlternateComponentMasterDto> GetByModel(int modelId);

        List<AlternateComponentMasterDto> GetByComponent(int componentId);
    }
}