namespace DotNetBackend.DTOs.Invoice
{
    public class InvoiceResponseDto
    {
        public InvoiceHeaderDto Header { get; set; }
            = new();

        public List<InvoiceDetailDto> Details { get; set; }
            = new();
    }
}