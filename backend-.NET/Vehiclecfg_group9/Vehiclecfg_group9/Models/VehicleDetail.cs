using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class VehicleDetail
{
    public int ConfiId { get; set; }

    public string CompType { get; set; } = null!;

    public bool IsConfigurable { get; set; }

    public int CompId { get; set; }

    public int ModelId { get; set; }

    public virtual ComponentMaster Comp { get; set; } = null!;

    public virtual ModelMaster Model { get; set; } = null!;
}
