namespace DotNetBackend.DTOs
{
    public class VehicleDetailsResponseDto
    {
        public int ModelId { get; set; }

        public string? ModelName { get; set; }

        public string? MfgName { get; set; }

        public string? SegmentName { get; set; }

        public decimal BasePrice { get; set; }

        public string? ImagePath { get; set; }

        public List<ComponentMasterDto> CoreComponents { get; set; }
            = new();

        public List<ComponentMasterDto> InteriorComponents { get; set; }
            = new();

        public List<ComponentMasterDto> ExteriorComponents { get; set; }
            = new();

        public List<ComponentMasterDto> StandardComponents { get; set; }
            = new();
    }
}