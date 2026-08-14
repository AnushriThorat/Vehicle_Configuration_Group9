using System.Text;
using DotNetBackend.Configurations;
using DotNetBackend.Data;
using DotNetBackend.Helpers;
using DotNetBackend.Mappings;
using DotNetBackend.Middleware;
using DotNetBackend.Repositories.Implementations;
using DotNetBackend.Repositories.Interfaces;
using DotNetBackend.Services.Implementations;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;

namespace DotNetBackend
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // ============================================
            // Add Services
            // ============================================

            builder.Services.AddControllers();

            builder.Services.AddEndpointsApiExplorer();

            builder.Services.AddSwaggerGen();

            // ============================================
            // Database Configuration
            // ============================================

            builder.Services.AddDbContext<ApplicationDbContext>(options =>
                options.UseMySQL(
                    builder.Configuration.GetConnectionString("DefaultConnection")
                !));

            // ============================================
            // Build Application
            // ============================================
            builder.Services.AddHttpClient<IMailClientService, MailClientService>(client =>
            {
                client.BaseAddress = new Uri("http://localhost:5256");
            });
            builder.Services.AddScoped<IInvoiceService, InvoiceService>();
            builder.Services.AddScoped<IInvoiceRepository, InvoiceRepository>();
            builder.Services.AddScoped<IInvoiceDetailRepository, InvoiceDetailRepository>();
            builder.Services.AddScoped<IVehicleDetailRepository, VehicleDetailRepository>();
            builder.Services.AddScoped<IVehicleDetailService, VehicleDetailService>();
            builder.Services.AddScoped<IAlternateComponentRepository, AlternateComponentRepository>();
            builder.Services.AddScoped<IAlternateComponentService, AlternateComponentService>();
            builder.Services.AddScoped<IComponentMasterRepository, ComponentMasterRepository>();
            builder.Services.AddScoped<IComponentMasterService, ComponentMasterService>();
            builder.Services.AddScoped<IModelMasterRepository, ModelMasterRepository>();
            builder.Services.AddScoped<IModelMasterService, ModelMasterService>();
            builder.Services.AddScoped<IMfgMasterRepository, MfgMasterRepository>();
            builder.Services.AddScoped<IMfgMasterService, MfgMasterService>();
            builder.Services.AddScoped<ISegmentMasterService, SegmentMasterService>();
            builder.Services.AddScoped<ISegmentMasterRepository, SegmentMasterRepository>();
            builder.Services.AddScoped<IUserRepository, UserRepository>();
            builder.Services.AddScoped<IAuthService, AuthService>();
            builder.Services.Configure<JwtSettings>(
                builder.Configuration.GetSection("Jwt"));
            builder.Services.AddScoped<JwtService>();
            builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        var jwtSettings = builder.Configuration
            .GetSection("Jwt")
            .Get<JwtSettings>();

        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,

            ValidIssuer = jwtSettings!.Issuer,
            ValidAudience = jwtSettings.Audience,

            IssuerSigningKey = new SymmetricSecurityKey(
                Encoding.UTF8.GetBytes(jwtSettings.Key))
        };
    });
            builder.Services.AddAutoMapper(typeof(MappingProfile));
            var app = builder.Build();

            // ============================================
            // Configure HTTP Request Pipeline
            // ============================================

            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();

                app.UseSwaggerUI();
            }

            app.UseMiddleware<ExceptionMiddleware>();
            app.UseHttpsRedirection();

            app.UseAuthentication();

            app.UseAuthorization();

            app.MapControllers();

            app.Run();
        }
    }
}