using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("segment_master")]
public partial class SegmentMaster
{
    [Key]
    [Column("seg_id")]
    public int SegId { get; set; }

    [Column("min_qty")]
    public int? MinQty { get; set; }

    [Column("seg_name")]
    [StringLength(255)]
    public string? SegName { get; set; }

    [InverseProperty("Seg")]
    public virtual ICollection<MfgMaster> MfgMasters { get; set; } = new List<MfgMaster>();

    [InverseProperty("Seg")]
    public virtual ICollection<ModelMaster> ModelMasters { get; set; } = new List<ModelMaster>();
}
