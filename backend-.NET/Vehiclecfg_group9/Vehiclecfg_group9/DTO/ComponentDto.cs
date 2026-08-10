namespace Vehiclecfg_group9.DTO
{
    public class ComponentDto
    {
        public int CompId { get; set; }

        public string? CompName { get; set; }

        public bool IsConfigurable { get; set; }

        public decimal? DeltaPrice { get; set; }
    }
}