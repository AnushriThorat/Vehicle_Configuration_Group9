namespace DotNetBackend.DTOs.Invoice
{
    public class InvoiceHeaderDto
    {
        public long InvoiceId { get; set; }

        public DateTime InvoiceDate { get; set; }

        public double NetAmount { get; set; }

        public double Tax { get; set; }

        public double TotalAmount { get; set; }

        public string CustomerName { get; set; } = "";

        public string ModelName { get; set; } = "";
    }
}