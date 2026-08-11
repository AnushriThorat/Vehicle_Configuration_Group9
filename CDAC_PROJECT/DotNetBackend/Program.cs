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
            var builder =
                WebApplication.CreateBuilder(args);


            // =====================================================
            // CONTROLLERS
            // =====================================================

            builder.Services.AddControllers();

            builder.Services.AddEndpointsApiExplorer();

            builder.Services.AddSwaggerGen();


            // =====================================================
            // DATABASE
            // =====================================================

            builder.Services.AddDbContext<ApplicationDbContext>(
                options =>
                {
                    options.UseMySQL(
                        builder.Configuration
                            .GetConnectionString(
                                "DefaultConnection"
                            )!
                    );
                }
            );


            // =====================================================
            // HTTP CLIENT
            // .NET → SPRING BOOT MAIL MICROSERVICE
            // =====================================================

            builder.Services.AddHttpClient<
                IMailClientService,
                MailClientService
            >(
                client =>
                {
                    client.BaseAddress =
                        new Uri(
                            "http://localhost:8081"
                        );

                    client.Timeout =
                        TimeSpan.FromSeconds(60);
                }
            );


            // =====================================================
            // USER
            // =====================================================

            builder.Services.AddScoped<
                IUserRepository,
                UserRepository
            >();

            builder.Services.AddScoped<
                IUserService,
                UserService
            >();


            // =====================================================
            // AUTHENTICATION
            // =====================================================

            builder.Services.AddScoped<
                IAuthService,
                AuthService
            >();

            builder.Services.Configure<JwtSettings>(
                builder.Configuration.GetSection("Jwt")
            );

            builder.Services.AddScoped<JwtService>();


            // =====================================================
            // INVOICE
            // =====================================================

            builder.Services.AddScoped<
                IInvoiceRepository,
                InvoiceRepository
            >();

            builder.Services.AddScoped<
                IInvoiceDetailRepository,
                InvoiceDetailRepository
            >();

            builder.Services.AddScoped<
                IInvoiceService,
                InvoiceService
            >();


            // =====================================================
            // VEHICLE DETAILS
            // =====================================================

            builder.Services.AddScoped<
                IVehicleDetailRepository,
                VehicleDetailRepository
            >();

            builder.Services.AddScoped<
                IVehicleDetailService,
                VehicleDetailService
            >();


            // =====================================================
            // ALTERNATE COMPONENT
            // =====================================================

            builder.Services.AddScoped<
                IAlternateComponentRepository,
                AlternateComponentRepository
            >();

            builder.Services.AddScoped<
                IAlternateComponentService,
                AlternateComponentService
            >();


            // =====================================================
            // COMPONENT MASTER
            // =====================================================

            builder.Services.AddScoped<
                IComponentMasterRepository,
                ComponentMasterRepository
            >();

            builder.Services.AddScoped<
                IComponentMasterService,
                ComponentMasterService
            >();


            // =====================================================
            // MODEL MASTER
            // =====================================================

            builder.Services.AddScoped<
                IModelMasterRepository,
                ModelMasterRepository
            >();

            builder.Services.AddScoped<
                IModelMasterService,
                ModelMasterService
            >();


            // =====================================================
            // MANUFACTURER MASTER
            // =====================================================

            builder.Services.AddScoped<
                IMfgMasterRepository,
                MfgMasterRepository
            >();

            builder.Services.AddScoped<
                IMfgMasterService,
                MfgMasterService
            >();


            // =====================================================
            // SEGMENT MASTER
            // =====================================================

            builder.Services.AddScoped<
                ISegmentMasterRepository,
                SegmentMasterRepository
            >();

            builder.Services.AddScoped<
                ISegmentMasterService,
                SegmentMasterService
            >();


            // =====================================================
            // AUTO MAPPER
            // =====================================================

            builder.Services.AddAutoMapper(
                typeof(MappingProfile)
            );


            // =====================================================
            // JWT AUTHENTICATION
            // =====================================================

            var jwtSettings =
                builder.Configuration
                    .GetSection("Jwt")
                    .Get<JwtSettings>();


            if (jwtSettings == null)
            {
                throw new InvalidOperationException(
                    "JWT configuration is missing."
                );
            }


            builder.Services.AddAuthentication(
                JwtBearerDefaults.AuthenticationScheme
            )
            .AddJwtBearer(
                options =>
                {
                    options.TokenValidationParameters =
                        new TokenValidationParameters
                        {
                            ValidateIssuer = true,

                            ValidateAudience = true,

                            ValidateLifetime = true,

                            ValidateIssuerSigningKey = true,

                            ValidIssuer =
                                jwtSettings.Issuer,

                            ValidAudience =
                                jwtSettings.Audience,

                            IssuerSigningKey =
                                new SymmetricSecurityKey(
                                    Encoding.UTF8.GetBytes(
                                        jwtSettings.Key
                                    )
                                )
                        };
                }
            );


            // =====================================================
            // CORS
            // =====================================================

            builder.Services.AddCors(
                options =>
                {
                    options.AddPolicy(
                        "ReactPolicy",
                        policy =>
                        {
                            policy
                                .WithOrigins(
                                    "http://localhost:5173"
                                )
                                .AllowAnyHeader()
                                .AllowAnyMethod()
                                .AllowCredentials();
                        }
                    );
                }
            );


            // =====================================================
            // BUILD APPLICATION
            // =====================================================

            var app =
                builder.Build();


            // =====================================================
            // SWAGGER
            // =====================================================

            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();

                app.UseSwaggerUI();
            }


            // =====================================================
            // MIDDLEWARE
            // =====================================================

            app.UseMiddleware<ExceptionMiddleware>();

            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseCors("ReactPolicy");

            app.UseAuthentication();

            app.UseAuthorization();


            // =====================================================
            // CONTROLLERS
            // =====================================================

            app.MapControllers();


            // =====================================================
            // RUN
            // =====================================================

            app.Run();
        }
    }
}