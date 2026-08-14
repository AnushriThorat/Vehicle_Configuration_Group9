using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("mfg_master")]
[Index("SegId", Name = "FKok5qd64lq1asv75hpfgpwhdyq")]
public partial class MfgMaster
{
    [Key]
    [Column("mfg_id")]
    public int MfgId { get; set; }

    [Column("mfg_name")]
    [StringLength(255)]
    public string? MfgName { get; set; }

    [Column("seg_id")]
    public int? SegId { get; set; }

    [InverseProperty("Mfg")]
    public virtual ICollection<ModelMaster> ModelMasters { get; set; } = new List<ModelMaster>();

    [ForeignKey("SegId")]
    [InverseProperty("MfgMasters")]
    public virtual SegmentMaster? Seg { get; set; }
}
