namespace DotNetBackend.DTOs.Invoice
{
    public class InvoiceItemDto
    {
        public int CompId { get; set; }

        public int AltCompId { get; set; }

        public double DeltaPrice { get; set; }
    }
}