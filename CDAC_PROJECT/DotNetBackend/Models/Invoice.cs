using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("invoice")]
[Index("Id", Name = "FK1wpyuwr7s4xc9wbjywkbril9c")]
[Index("ModelId", Name = "FKarg94e2qrxsjeet2tdq8h3nbb")]
public partial class Invoice
{
    [Key]
    [Column("inv_id")]
    public long InvId { get; set; }

    [Column("inv_date")]
    [MaxLength(6)]
    public DateTime? InvDate { get; set; }

    [Column("net_amt")]
    public double? NetAmt { get; set; }

    [Column("tax")]
    public double? Tax { get; set; }

    [Column("total_amt")]
    public double? TotalAmt { get; set; }

    [Column("model_id")]
    public int ModelId { get; set; }

    [Column("id")]
    public int Id { get; set; }

    [ForeignKey("Id")]
    [InverseProperty("Invoices")]
    public virtual User IdNavigation { get; set; } = null!;

    [InverseProperty("Inv")]
    public virtual ICollection<InvoiceDetail> InvoiceDetails { get; set; } = new List<InvoiceDetail>();

    [ForeignKey("ModelId")]
    [InverseProperty("Invoices")]
    public virtual ModelMaster Model { get; set; } = null!;
}
