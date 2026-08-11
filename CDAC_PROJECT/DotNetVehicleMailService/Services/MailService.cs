using MailKit.Net.Smtp;
using MailKit.Security;
using MimeKit;
using VehicleMailService.Interfaces;
using Microsoft.Extensions.Options;
using VehicleMailService.Models;

namespace VehicleMailService.Services
{
    public class MailService : IMailService
    {
        private readonly MailSettings _mailSettings;

        public MailService(IOptions<MailSettings> mailSettings)
        {
            _mailSettings = mailSettings.Value;
        }

        public async Task SendInvoiceMail(
            string email,
            string subject,
            string body,
            byte[] pdfBytes,
            string fileName)
        {
            try
            {
                var message = new MimeMessage();

                message.From.Add(
                    MailboxAddress.Parse(_mailSettings.Username));

                message.To.Add(
                    MailboxAddress.Parse(email));

                message.Subject = subject;

                var builder = new BodyBuilder
                {
                    TextBody = body
                };

                if (pdfBytes != null && pdfBytes.Length > 0)
                {
                    builder.Attachments.Add(
                        fileName,
                        pdfBytes,
                        new ContentType(
                            "application",
                            "pdf"));
                }

                message.Body = builder.ToMessageBody();

                using var smtp = new SmtpClient();

                await smtp.ConnectAsync(
                    _mailSettings.Smtp,
                    _mailSettings.Port,
                    SecureSocketOptions.StartTls);

                await smtp.AuthenticateAsync(
                    _mailSettings.Username,
                    _mailSettings.Password);

                await smtp.SendAsync(message);

                await smtp.DisconnectAsync(true);

                Console.WriteLine("MAIL SENT SUCCESSFULLY");
            }
            catch (Exception ex)
            {
                throw new Exception(
                    "Unable to send Email", ex);
            }
        }
    }
}