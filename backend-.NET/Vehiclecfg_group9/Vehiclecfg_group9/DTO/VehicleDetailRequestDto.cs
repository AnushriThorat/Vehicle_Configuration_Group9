using System.ComponentModel.DataAnnotations;

namespace Vehiclecfg_group9.DTO
{
    public class VehicleDetailRequestDto
    {
        [Required]
        public int ModelId { get; set; }

        [Required]
        public int CompId { get; set; }

        [Required]
        [StringLength(1)]
        public string CompType { get; set; } = string.Empty;

        [Required]
        public bool IsConfigurable { get; set; }
    }
}