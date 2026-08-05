using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class InvoiceDetail
{
    public int InvdtlId { get; set; }

    public double? DeltaPrice { get; set; }

    public int AltCompId { get; set; }

    public int CompId { get; set; }

    public long InvId { get; set; }

    public int ModelId { get; set; }

    public virtual ComponentMaster AltComp { get; set; } = null!;

    public virtual ComponentMaster Comp { get; set; } = null!;

    public virtual Invoice Inv { get; set; } = null!;

    public virtual ModelMaster Model { get; set; } = null!;
}
