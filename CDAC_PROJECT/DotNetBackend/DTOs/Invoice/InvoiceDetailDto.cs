namespace DotNetBackend.DTOs.Invoice
{
    public class InvoiceDetailDto
    {
        public int ComponentId { get; set; }

        public string ComponentName { get; set; } = "";

        public int AlternateComponentId { get; set; }

        public string AlternateComponentName { get; set; } = "";

        public double DeltaPrice { get; set; }
    }
}