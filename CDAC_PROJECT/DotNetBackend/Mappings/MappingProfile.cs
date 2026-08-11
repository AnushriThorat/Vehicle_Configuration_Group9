using AutoMapper;
using DotNetBackend.DTOs;
using DotNetBackend.DTOs.Invoice;
using DotNetBackend.Models;

namespace DotNetBackend.Mappings
{
    public class MappingProfile : Profile
    {
        public MappingProfile()
        {

            CreateMap<User, UserDto>();
            // ==========================
            // Segment Master
            // ==========================
            CreateMap<SegmentMaster, SegmentMasterDto>()
                .ReverseMap();

            // ==========================
            // Manufacturer Master
            // ==========================
            CreateMap<MfgMaster, MfgMasterDto>()
                .ForMember(
                    dest => dest.SegmentName,
                    opt => opt.MapFrom(src =>
                        src.Seg != null
                            ? src.Seg.SegName
                            : null)
                )
                .ReverseMap();

            // ==========================
            // Model Master
            // ==========================
            CreateMap<ModelMaster, ModelMasterDto>()
                .ForMember(
                    dest => dest.MfgName,
                    opt => opt.MapFrom(src =>
                        src.Mfg != null
                            ? src.Mfg.MfgName
                            : null)
                )
                .ForMember(
                    dest => dest.SegName,
                    opt => opt.MapFrom(src =>
                        src.Seg != null
                            ? src.Seg.SegName
                            : null)
                )
                .ReverseMap();

            // ==========================
            // Component Master
            // ==========================
            CreateMap<ComponentMaster, ComponentMasterDto>()
                .ReverseMap();

            // ==========================
            // Alternate Component
            // ==========================
            CreateMap<AlternateComponentMaster, AlternateComponentMasterDto>()
                .ForMember(
                    dest => dest.ModelName,
                    opt => opt.MapFrom(src =>
                        src.Model.ModelName)
                )
                .ForMember(
                    dest => dest.ComponentName,
                    opt => opt.MapFrom(src =>
                        src.Comp.CompName)
                )
                .ForMember(
                    dest => dest.AlternateComponentName,
                    opt => opt.MapFrom(src =>
                        src.AltComp != null
                            ? src.AltComp.CompName
                            : null)
                )
                .ReverseMap();

            // ==========================
            // Vehicle Detail
            // ==========================
            CreateMap<VehicleDetail, VehicleDetailDto>()
                .ForMember(
                    dest => dest.ModelName,
                    opt => opt.MapFrom(src =>
                        src.Model.ModelName)
                )
                .ForMember(
                    dest => dest.ComponentName,
                    opt => opt.MapFrom(src =>
                        src.Comp.CompName)
                )
                .ForMember(
                    dest => dest.IsConfigurable,
                    opt => opt.MapFrom(src =>
                        src.IsConfigurable == 1)
                );

            CreateMap<VehicleDetailDto, VehicleDetail>()
                .ForMember(
                    dest => dest.IsConfigurable,
                    opt => opt.MapFrom(src =>
                        src.IsConfigurable ? 1UL : 0UL)
                );

            CreateMap<Invoice, InvoiceHeaderDto>()
    .ForMember(d => d.InvoiceId,
        o => o.MapFrom(s => s.InvId))
    .ForMember(d => d.CustomerName,
        o => o.MapFrom(s => s.IdNavigation.CompanyName))
    .ForMember(d => d.ModelName,
        o => o.MapFrom(s => s.Model.ModelName));

            CreateMap<InvoiceDetail, InvoiceDetailDto>()
                .ForMember(d => d.ComponentId,
                    o => o.MapFrom(s => s.CompId))
                .ForMember(d => d.ComponentName,
                    o => o.MapFrom(s => s.Comp.CompName))
                .ForMember(d => d.AlternateComponentId,
                    o => o.MapFrom(s => s.AltCompId))
                .ForMember(d => d.AlternateComponentName,
                    o => o.MapFrom(s => s.AltComp.CompName));
        }
    }
}