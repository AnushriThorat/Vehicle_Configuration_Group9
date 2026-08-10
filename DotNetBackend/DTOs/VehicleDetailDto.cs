namespace DotNetBackend.DTOs
{
    public class VehicleDetailDto
    {
        public int ConfiId { get; set; }

        public int ModelId { get; set; }

        public string? ModelName { get; set; }

        public int CompId { get; set; }

        public string? ComponentName { get; set; }

        public string CompType { get; set; } = string.Empty;

        public bool IsConfigurable { get; set; }
    }
}