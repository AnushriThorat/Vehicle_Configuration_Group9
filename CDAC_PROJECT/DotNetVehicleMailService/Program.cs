using VehicleMailService.Interfaces;
using VehicleMailService.Models;
using VehicleMailService.Services;

var builder = WebApplication.CreateBuilder(args);

builder.Services.Configure<MailSettings>(
    builder.Configuration.GetSection("MailSettings"));

builder.Services.AddScoped<IMailService, MailService>();

builder.Services.AddControllers();

builder.Services.AddEndpointsApiExplorer();

var app = builder.Build();

app.UseAuthorization();

app.MapControllers();

app.Run();