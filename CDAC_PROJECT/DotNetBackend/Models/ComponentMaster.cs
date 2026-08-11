using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("component_master")]
[Index("CompName", Name = "UKeva2rs1loskklo40bsl29imme", IsUnique = true)]
public partial class ComponentMaster
{
    [Key]
    [Column("comp_id")]
    public int CompId { get; set; }

    [Column("comp_name")]
    public string CompName { get; set; } = null!;

    [InverseProperty("AltComp")]
    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasterAltComps { get; set; } = new List<AlternateComponentMaster>();

    [InverseProperty("Comp")]
    public virtual ICollection<AlternateComponentMaster> AlternateComponentMasterComps { get; set; } = new List<AlternateComponentMaster>();

    [InverseProperty("AltComp")]
    public virtual ICollection<InvoiceDetail> InvoiceDetailAltComps { get; set; } = new List<InvoiceDetail>();

    [InverseProperty("Comp")]
    public virtual ICollection<InvoiceDetail> InvoiceDetailComps { get; set; } = new List<InvoiceDetail>();

    [InverseProperty("Comp")]
    public virtual ICollection<VehicleDetail> VehicleDetails { get; set; } = new List<VehicleDetail>();
}
