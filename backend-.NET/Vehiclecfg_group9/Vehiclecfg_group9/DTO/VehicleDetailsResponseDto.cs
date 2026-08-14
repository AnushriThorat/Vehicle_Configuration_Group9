namespace Vehiclecfg_group9.DTO
{
    public class VehicleDetailsResponseDto
    {
        public int ModelId { get; set; }

        public string? ModelName { get; set; }

        public string? ImagePath { get; set; }

        public decimal BasePrice { get; set; }

        public int MfgId { get; set; }

        public string? MfgName { get; set; }

        public int SegId { get; set; }

        public string? SegName { get; set; }

        public List<ComponentDto> CoreComponents { get; set; } = new();

        public List<ComponentDto> InteriorComponents { get; set; } = new();

        public List<ComponentDto> ExteriorComponents { get; set; } = new();

        public List<ComponentDto> StandardComponents { get; set; } = new();
    }
}