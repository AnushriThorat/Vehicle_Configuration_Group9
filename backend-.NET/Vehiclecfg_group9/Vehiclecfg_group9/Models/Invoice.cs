using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class Invoice
{
    public long InvId { get; set; }

    public DateTime? InvDate { get; set; }

    public double? NetAmt { get; set; }

    public double? Tax { get; set; }

    public double? TotalAmt { get; set; }

    public int ModelId { get; set; }

    public int Id { get; set; }

    public virtual User IdNavigation { get; set; } = null!;

    public virtual ICollection<InvoiceDetail> InvoiceDetails { get; set; } = new List<InvoiceDetail>();

    public virtual ModelMaster Model { get; set; } = null!;
}
