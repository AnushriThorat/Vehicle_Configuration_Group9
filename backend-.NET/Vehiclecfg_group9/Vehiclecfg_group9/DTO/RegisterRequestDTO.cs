namespace Vehiclecfg_group9.DTO
{
    public class RegisterRequestDTO
    {
        public string Username { get; set; } = string.Empty;

        public string Password { get; set; } = string.Empty;

        public string? CompanyName { get; set; }

        public string? CompanyEmail { get; set; }

        public string? RegistrationNo { get; set; }

        public string? HoldingType { get; set; }

        public string? Add1 { get; set; }

        public string? Add2 { get; set; }

        public string? City { get; set; }

        public string? State { get; set; }

        public string? Pin { get; set; }

        public string? AuthName { get; set; }

        public string? Designation { get; set; }

        public string? AuthTel { get; set; }

        public string? Cell { get; set; }

        public string? Phone { get; set; }

        public string? Fax { get; set; }

        public string? CompanyStNo { get; set; }

        public string? CompanyVatNo { get; set; }

        public string? TaxPan { get; set; }
    }
}
