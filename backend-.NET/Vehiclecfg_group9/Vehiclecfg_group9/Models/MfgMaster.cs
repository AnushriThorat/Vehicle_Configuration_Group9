using System;
using System.Collections.Generic;

namespace Vehiclecfg_group9.Models;

public partial class MfgMaster
{
    public int MfgId { get; set; }

    public string? MfgName { get; set; }

    public int? SegId { get; set; }

    public virtual ICollection<ModelMaster> ModelMasters { get; set; } = new List<ModelMaster>();

    public virtual SegmentMaster? Seg { get; set; }
}
