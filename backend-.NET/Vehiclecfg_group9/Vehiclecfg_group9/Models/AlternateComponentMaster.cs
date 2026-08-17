using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class AlternateComponentMaster
{
    public int AltId { get; set; }

    public double? DeltaPrice { get; set; }

    public int? AltCompId { get; set; }

    public int CompId { get; set; }

    public int ModelId { get; set; }

    public virtual ComponentMaster? AltComp { get; set; }

    public virtual ComponentMaster Comp { get; set; } = null!;

    public virtual ModelMaster Model { get; set; } = null!;
}
