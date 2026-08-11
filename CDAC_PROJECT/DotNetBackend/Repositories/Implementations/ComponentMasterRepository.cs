using DotNetBackend.Data;
using DotNetBackend.Models;
using DotNetBackend.Repositories.Generic;
using DotNetBackend.Repositories.Interfaces;

namespace DotNetBackend.Repositories.Implementations
{
    public class ComponentMasterRepository :
        GenericRepository<ComponentMaster>,
        IComponentMasterRepository
    {
        public ComponentMasterRepository(
            ApplicationDbContext context)
            : base(context)
        {

        }
    }
}