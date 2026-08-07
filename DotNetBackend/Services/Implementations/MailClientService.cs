using DotNetBackend.DTOs.Mail;
using DotNetBackend.Services.Interfaces;
using System.Net.Http.Json;

namespace DotNetBackend.Services.Implementations
{
    public class MailClientService : IMailClientService
    {
        private readonly HttpClient _httpClient;

        public MailClientService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task SendInvoiceAsync(MailRequestDto request)
        {
            var response = await _httpClient.PostAsJsonAsync(
                "api/mail/send-invoice",
                request);

            if (!response.IsSuccessStatusCode)
            {
                var error = await response.Content.ReadAsStringAsync();

                throw new Exception(
                    $"Mail Service Error : {error}");
            }
        }
    }
}