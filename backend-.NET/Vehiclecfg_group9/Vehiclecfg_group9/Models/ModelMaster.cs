using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class ModelMaster
{
    public int ModelId { get; set; }

    public decimal BasePrice { get; set; }

    public string? ImagePath { get; set; }

    public string? ModelName { get; set; }

    public int? MfgId { get; set; }

    public int? SegId { get; set; }

    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasters { get; set; } = new List<AlternateComponentMaster>();

    public virtual ICollection<InvoiceDetail> InvoiceDetails { get; set; } = new List<InvoiceDetail>();

    public virtual ICollection<Invoice> Invoices { get; set; } = new List<Invoice>();

    public virtual MfgMaster? Mfg { get; set; }

    public virtual SegmentMaster? Seg { get; set; }

    public virtual ICollection<VehicleDetail> VehicleDetails { get; set; } = new List<VehicleDetail>();
}
