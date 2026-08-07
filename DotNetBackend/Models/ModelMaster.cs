using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("model_master")]
[Index("MfgId", Name = "FKacbx0rmpiqwgiisi06lsfcw6f")]
[Index("SegId", Name = "FKtpmev85psi1n73w058nmykixb")]
public partial class ModelMaster
{
    [Key]
    [Column("model_id")]
    public int ModelId { get; set; }

    [Column("base_price")]
    [Precision(12)]
    public decimal BasePrice { get; set; }

    [Column("image_path")]
    [StringLength(255)]
    public string? ImagePath { get; set; }

    [Column("model_name")]
    [StringLength(255)]
    public string? ModelName { get; set; }

    [Column("mfg_id")]
    public int? MfgId { get; set; }

    [Column("seg_id")]
    public int? SegId { get; set; }

    [InverseProperty("Model")]
    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasters { get; set; } = new List<AlternateComponentMaster>();

    [InverseProperty("Model")]
    public virtual ICollection<InvoiceDetail> InvoiceDetails { get; set; } = new List<InvoiceDetail>();

    [InverseProperty("Model")]
    public virtual ICollection<Invoice> Invoices { get; set; } = new List<Invoice>();

    [ForeignKey("MfgId")]
    [InverseProperty("ModelMasters")]
    public virtual MfgMaster? Mfg { get; set; }

    [ForeignKey("SegId")]
    [InverseProperty("ModelMasters")]
    public virtual SegmentMaster? Seg { get; set; }

    [InverseProperty("Model")]
    public virtual ICollection<VehicleDetail> VehicleDetails { get; set; } = new List<VehicleDetail>();
}
