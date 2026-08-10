namespace DotNetBackend.DTOs
{
    public class AlternateComponentMasterDto
    {
        public int AltId { get; set; }

        public int ModelId { get; set; }

        public string? ModelName { get; set; }

        public int CompId { get; set; }

        public string? ComponentName { get; set; }

        public int? AltCompId { get; set; }

        public string? AlternateComponentName { get; set; }

        public double? DeltaPrice { get; set; }
    }
}