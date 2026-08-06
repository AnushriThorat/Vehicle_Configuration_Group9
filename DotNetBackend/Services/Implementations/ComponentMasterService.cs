using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Generic;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class ComponentMasterService :
        GenericService<ComponentMaster, ComponentMasterDto>,
        IComponentMasterService
    {
        public ComponentMasterService(
            IComponentMasterRepository repository,
            IMapper mapper)
            : base(repository, mapper)
        {

        }
    }
}