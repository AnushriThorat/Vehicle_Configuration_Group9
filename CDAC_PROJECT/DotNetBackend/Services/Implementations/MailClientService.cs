using System.Net.Http.Json;
using DotNetBackend.DTOs.Mail;
using DotNetBackend.Services.Interfaces;

namespace DotNetBackend.Services.Implementations
{
    public class MailClientService : IMailClientService
    {
        private readonly HttpClient _httpClient;

        public MailClientService(
            HttpClient httpClient)
        {
            _httpClient = httpClient;
        }


        public async Task SendInvoiceAsync(
            MailRequestDto request)
        {
            if (request == null)
            {
                throw new Exception(
                    "Mail request cannot be null."
                );
            }


            if (string.IsNullOrWhiteSpace(
                    request.Email))
            {
                throw new Exception(
                    "Email is required."
                );
            }


            if (string.IsNullOrWhiteSpace(
                    request.Pdf))
            {
                throw new Exception(
                    "PDF is required."
                );
            }


            var response =
                await _httpClient.PostAsJsonAsync(
                    "/api/mail/send-invoice",
                    request
                );


            if (!response.IsSuccessStatusCode)
            {
                var error =
                    await response.Content.ReadAsStringAsync();

                throw new Exception(
                    $"Spring Mail Service failed: {error}"
                );
            }
        }
    }
}