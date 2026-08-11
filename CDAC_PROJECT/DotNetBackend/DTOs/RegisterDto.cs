namespace DotNetBackend.DTOs
{
    public class RegisterDto
    {
        public int Id { get; set; } 
        public string Username { get; set; } = string.Empty;

        public string Password { get; set; } = string.Empty;

        public string CompanyName { get; set; } = string.Empty;

        public string CompanyEmail { get; set; } = string.Empty;
    }
}