using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("vehicle_detail")]
[Index("CompId", Name = "FKhih0q8yg3skwicdw9e0kigiti")]
[Index("ModelId", Name = "FKob8nyvm56uj4gbkm8kjdwmole")]
public partial class VehicleDetail
{
    [Key]
    [Column("confi_id")]
    public int ConfiId { get; set; }

    [Column("comp_type", TypeName = "enum('C','E','I','S')")]
    public string CompType { get; set; } = null!;

    [Column("is_configurable", TypeName = "bit(1)")]
    public ulong IsConfigurable { get; set; }

    [Column("comp_id")]
    public int CompId { get; set; }

    [Column("model_id")]
    public int ModelId { get; set; }

    [ForeignKey("CompId")]
    [InverseProperty("VehicleDetails")]
    public virtual ComponentMaster Comp { get; set; } = null!;

    [ForeignKey("ModelId")]
    [InverseProperty("VehicleDetails")]
    public virtual ModelMaster Model { get; set; } = null!;
}
