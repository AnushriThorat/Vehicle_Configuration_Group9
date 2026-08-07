using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("alternate_component_master")]
[Index("AltCompId", Name = "FKnnmfalcksg51qu0o4quupn69h")]
[Index("CompId", Name = "FKpgv8oj5ulg440a3vrcefmyp24")]
[Index("ModelId", Name = "FKqcb29n3rowc4mio33w5t3770b")]
public partial class AlternateComponentMaster
{
    [Key]
    [Column("alt_id")]
    public int AltId { get; set; }

    [Column("delta_price")]
    public double? DeltaPrice { get; set; }

    [Column("alt_comp_id")]
    public int? AltCompId { get; set; }

    [Column("comp_id")]
    public int CompId { get; set; }

    [Column("model_id")]
    public int ModelId { get; set; }

    [ForeignKey("AltCompId")]
    [InverseProperty("AlternateComponentMasterAltComps")]
    public virtual ComponentMaster? AltComp { get; set; }

    [ForeignKey("CompId")]
    [InverseProperty("AlternateComponentMasterComps")]
    public virtual ComponentMaster Comp { get; set; } = null!;

    [ForeignKey("ModelId")]
    [InverseProperty("AlternateComponentMasters")]
    public virtual ModelMaster Model { get; set; } = null!;
}
