namespace DotNetBackend.DTOs.Invoice
{
    public class InvoiceRequestDto
    {
        public int UserId { get; set; }

        public int ModelId { get; set; }

        public List<InvoiceItemDto> Items { get; set; }
            = new();
    }
}