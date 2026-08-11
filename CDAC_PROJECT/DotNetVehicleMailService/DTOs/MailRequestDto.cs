namespace VehicleMailService.DTOs
{
    public class MailRequestDto
    {
        public string Email { get; set; } = string.Empty;

        public string Subject { get; set; } = string.Empty;

        public string Body { get; set; } = string.Empty;

        public string Pdf { get; set; } = string.Empty;

        public string FileName { get; set; } = string.Empty;
    }
}