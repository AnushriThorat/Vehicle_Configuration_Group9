using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class SegmentMaster
{
    public int SegId { get; set; }

    public int? MinQty { get; set; }

    public string? SegName { get; set; }

    public virtual ICollection<MfgMaster> MfgMasters { get; set; } = new List<MfgMaster>();

    public virtual ICollection<ModelMaster> ModelMasters { get; set; } = new List<ModelMaster>();
}
