using DotNetBackend.DTOs.Mail;

namespace DotNetBackend.Services.Interfaces
{
    public interface IMailClientService
    {
        Task SendInvoiceAsync(
            MailRequestDto request);
    }
}