using Vehiclecfg_group9.data;
using Vehiclecfg_group9.Models;
using Vehiclecfg_group9.Repository;
using Vehiclecfg_group9.Services;

namespace Vehiclecfg_group9
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();

            // Database Context
            builder.Services.AddDbContext<VehicleCfgContext>();


            // =========================
            // Existing Services
            // =========================

            builder.Services.AddScoped<SegmentService>();
            builder.Services.AddScoped<MfgService>();


            // =========================
            // Generic Repository
            // =========================

            builder.Services.AddScoped<IGenericRepository<SegmentMaster>,
                                       GenericRepository<SegmentMaster>>();

            builder.Services.AddScoped<IGenericRepository<MfgMaster>,
                                       GenericRepository<MfgMaster>>();


            // =========================
            // Invoice Service
            // =========================

            builder.Services.AddScoped<IInvoiceService, InvoiceService>();


            // =========================
            // Invoice uses Generic Repository
            // =========================

            builder.Services.AddScoped<IGenericRepository<Invoice>,
                                       GenericRepository<Invoice>>();


            // OpenAPI
            builder.Services.AddOpenApi();


            var app = builder.Build();


            // Configure the HTTP request pipeline.

            if (app.Environment.IsDevelopment())
            {
                app.MapOpenApi();
            }


            app.UseHttpsRedirection();

            app.UseAuthorization();

            app.MapControllers();

            app.Run();
        }
    }
}