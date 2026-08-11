using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("invoice_detail")]
[Index("AltCompId", Name = "FK5vlnmeqvs94aljq9o3yj8a8jo")]
[Index("ModelId", Name = "FK8hkdrod8r0uqyviryvlgslhb8")]
[Index("CompId", Name = "FK9yfk9n3n5le7e7nnq939ybv4r")]
[Index("InvId", Name = "FKckt5u57libgdv8ot4vq1o46sr")]
public partial class InvoiceDetail
{
    [Key]
    [Column("invdtl_id")]
    public int InvdtlId { get; set; }

    [Column("delta_price")]
    public double? DeltaPrice { get; set; }

    [Column("alt_comp_id")]
    public int AltCompId { get; set; }

    [Column("comp_id")]
    public int CompId { get; set; }

    [Column("inv_id")]
    public long InvId { get; set; }

    [Column("model_id")]
    public int ModelId { get; set; }

    [ForeignKey("AltCompId")]
    [InverseProperty("InvoiceDetailAltComps")]
    public virtual ComponentMaster AltComp { get; set; } = null!;

    [ForeignKey("CompId")]
    [InverseProperty("InvoiceDetailComps")]
    public virtual ComponentMaster Comp { get; set; } = null!;

    [ForeignKey("InvId")]
    [InverseProperty("InvoiceDetails")]
    public virtual Invoice Inv { get; set; } = null!;

    [ForeignKey("ModelId")]
    [InverseProperty("InvoiceDetails")]
    public virtual ModelMaster Model { get; set; } = null!;
}
