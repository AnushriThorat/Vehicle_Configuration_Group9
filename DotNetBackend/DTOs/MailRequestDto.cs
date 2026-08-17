namespace DotNetBackend.DTOs
{
    public class MailRequestDto
    {
        public string Email { get; set; }

        public string Subject { get; set; }

        public string Body { get; set; }

        public string Pdf { get; set; }

        public string FileName { get; set; }
    }
}
