using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class ComponentMaster
{
    public int CompId { get; set; }

    public string CompName { get; set; } = null!;

    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasterAltComps { get; set; } = new List<AlternateComponentMaster>();

    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasterComps { get; set; } = new List<AlternateComponentMaster>();

    public virtual ICollection<InvoiceDetail> InvoiceDetailAltComps { get; set; } = new List<InvoiceDetail>();

    public virtual ICollection<InvoiceDetail> InvoiceDetailComps { get; set; } = new List<InvoiceDetail>();

    public virtual ICollection<VehicleDetail> VehicleDetails { get; set; } = new List<VehicleDetail>();
}
