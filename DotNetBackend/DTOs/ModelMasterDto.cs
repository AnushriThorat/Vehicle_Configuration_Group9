namespace DotNetBackend.DTOs
{
    public class ModelMasterDto
    {
        public int ModelId { get; set; }

        public string? ModelName { get; set; }

        public decimal BasePrice { get; set; }

        public string? ImagePath { get; set; }

        public int? MfgId { get; set; }

        public string? MfgName { get; set; }

        public int? SegId { get; set; }

        public string? SegName { get; set; }
    }
}