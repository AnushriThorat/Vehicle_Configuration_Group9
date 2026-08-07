using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;
using Vehiclecfg_group9.Models;

namespace Vehiclecfg_group9.data;

public partial class VehicleCfgContext : DbContext
{
    public VehicleCfgContext()
    {
    }

    public VehicleCfgContext(DbContextOptions<VehicleCfgContext> options)
        : base(options)
    {
    }

    public virtual DbSet<AlternateComponentMaster> AlternateComponentMasters { get; set; }

    public virtual DbSet<ComponentMaster> ComponentMasters { get; set; }

    public virtual DbSet<Invoice> Invoices { get; set; }

    public virtual DbSet<InvoiceDetail> InvoiceDetails { get; set; }

    public virtual DbSet<MfgMaster> MfgMasters { get; set; }

    public virtual DbSet<ModelMaster> ModelMasters { get; set; }

    public virtual DbSet<SegmentMaster> SegmentMasters { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<VehicleDetail> VehicleDetails { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;database=vehiclecfg_group9;user=root;password=Pratik@123", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.46-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<AlternateComponentMaster>(entity =>
        {
            entity.HasKey(e => e.AltId).HasName("PRIMARY");

            entity.ToTable("alternate_component_master");

            entity.HasIndex(e => e.AltCompId, "FKnnmfalcksg51qu0o4quupn69h");

            entity.HasIndex(e => e.CompId, "FKpgv8oj5ulg440a3vrcefmyp24");

            entity.HasIndex(e => e.ModelId, "FKqcb29n3rowc4mio33w5t3770b");

            entity.Property(e => e.AltId).HasColumnName("alt_id");
            entity.Property(e => e.AltCompId).HasColumnName("alt_comp_id");
            entity.Property(e => e.CompId).HasColumnName("comp_id");
            entity.Property(e => e.DeltaPrice).HasColumnName("delta_price");
            entity.Property(e => e.ModelId).HasColumnName("model_id");

            entity.HasOne(d => d.AltComp).WithMany(p => p.AlternateComponentMasterAltComps)
                .HasForeignKey(d => d.AltCompId)
                .HasConstraintName("FKnnmfalcksg51qu0o4quupn69h");

            entity.HasOne(d => d.Comp).WithMany(p => p.AlternateComponentMasterComps)
                .HasForeignKey(d => d.CompId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKpgv8oj5ulg440a3vrcefmyp24");

            entity.HasOne(d => d.Model).WithMany(p => p.AlternateComponentMasters)
                .HasForeignKey(d => d.ModelId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKqcb29n3rowc4mio33w5t3770b");
        });

        modelBuilder.Entity<ComponentMaster>(entity =>
        {
            entity.HasKey(e => e.CompId).HasName("PRIMARY");

            entity.ToTable("component_master");

            entity.HasIndex(e => e.CompName, "UKeva2rs1loskklo40bsl29imme").IsUnique();

            entity.Property(e => e.CompId).HasColumnName("comp_id");
            entity.Property(e => e.CompName).HasColumnName("comp_name");
        });

        modelBuilder.Entity<Invoice>(entity =>
        {
            entity.HasKey(e => e.InvId).HasName("PRIMARY");

            entity.ToTable("invoice");

            entity.HasIndex(e => e.Id, "FK1wpyuwr7s4xc9wbjywkbril9c");

            entity.HasIndex(e => e.ModelId, "FKarg94e2qrxsjeet2tdq8h3nbb");

            entity.Property(e => e.InvId).HasColumnName("inv_id");
            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.InvDate)
                .HasMaxLength(6)
                .HasColumnName("inv_date");
            entity.Property(e => e.ModelId).HasColumnName("model_id");
            entity.Property(e => e.NetAmt).HasColumnName("net_amt");
            entity.Property(e => e.Tax).HasColumnName("tax");
            entity.Property(e => e.TotalAmt).HasColumnName("total_amt");

            entity.HasOne(d => d.IdNavigation).WithMany(p => p.Invoices)
                .HasForeignKey(d => d.Id)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK1wpyuwr7s4xc9wbjywkbril9c");

            entity.HasOne(d => d.Model).WithMany(p => p.Invoices)
                .HasForeignKey(d => d.ModelId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKarg94e2qrxsjeet2tdq8h3nbb");
        });

        modelBuilder.Entity<InvoiceDetail>(entity =>
        {
            entity.HasKey(e => e.InvdtlId).HasName("PRIMARY");

            entity.ToTable("invoice_detail");

            entity.HasIndex(e => e.AltCompId, "FK5vlnmeqvs94aljq9o3yj8a8jo");

            entity.HasIndex(e => e.ModelId, "FK8hkdrod8r0uqyviryvlgslhb8");

            entity.HasIndex(e => e.CompId, "FK9yfk9n3n5le7e7nnq939ybv4r");

            entity.HasIndex(e => e.InvId, "FKckt5u57libgdv8ot4vq1o46sr");

            entity.Property(e => e.InvdtlId).HasColumnName("invdtl_id");
            entity.Property(e => e.AltCompId).HasColumnName("alt_comp_id");
            entity.Property(e => e.CompId).HasColumnName("comp_id");
            entity.Property(e => e.DeltaPrice).HasColumnName("delta_price");
            entity.Property(e => e.InvId).HasColumnName("inv_id");
            entity.Property(e => e.ModelId).HasColumnName("model_id");

            entity.HasOne(d => d.AltComp).WithMany(p => p.InvoiceDetailAltComps)
                .HasForeignKey(d => d.AltCompId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK5vlnmeqvs94aljq9o3yj8a8jo");

            entity.HasOne(d => d.Comp).WithMany(p => p.InvoiceDetailComps)
                .HasForeignKey(d => d.CompId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK9yfk9n3n5le7e7nnq939ybv4r");

            entity.HasOne(d => d.Inv).WithMany(p => p.InvoiceDetails)
                .HasForeignKey(d => d.InvId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKckt5u57libgdv8ot4vq1o46sr");

            entity.HasOne(d => d.Model).WithMany(p => p.InvoiceDetails)
                .HasForeignKey(d => d.ModelId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK8hkdrod8r0uqyviryvlgslhb8");
        });

        modelBuilder.Entity<MfgMaster>(entity =>
        {
            entity.HasKey(e => e.MfgId).HasName("PRIMARY");

            entity.ToTable("mfg_master");

            entity.HasIndex(e => e.SegId, "FKok5qd64lq1asv75hpfgpwhdyq");

            entity.Property(e => e.MfgId).HasColumnName("mfg_id");
            entity.Property(e => e.MfgName)
                .HasMaxLength(255)
                .HasColumnName("mfg_name");
            entity.Property(e => e.SegId).HasColumnName("seg_id");

            entity.HasOne(d => d.Seg).WithMany(p => p.MfgMasters)
                .HasForeignKey(d => d.SegId)
                .HasConstraintName("FKok5qd64lq1asv75hpfgpwhdyq");
        });

        modelBuilder.Entity<ModelMaster>(entity =>
        {
            entity.HasKey(e => e.ModelId).HasName("PRIMARY");

            entity.ToTable("model_master");

            entity.HasIndex(e => e.MfgId, "FKacbx0rmpiqwgiisi06lsfcw6f");

            entity.HasIndex(e => e.SegId, "FKtpmev85psi1n73w058nmykixb");

            entity.Property(e => e.ModelId).HasColumnName("model_id");
            entity.Property(e => e.BasePrice)
                .HasPrecision(12, 2)
                .HasColumnName("base_price");
            entity.Property(e => e.ImagePath)
                .HasMaxLength(255)
                .HasColumnName("image_path");
            entity.Property(e => e.MfgId).HasColumnName("mfg_id");
            entity.Property(e => e.ModelName)
                .HasMaxLength(255)
                .HasColumnName("model_name");
            entity.Property(e => e.SegId).HasColumnName("seg_id");

            entity.HasOne(d => d.Mfg).WithMany(p => p.ModelMasters)
                .HasForeignKey(d => d.MfgId)
                .HasConstraintName("FKacbx0rmpiqwgiisi06lsfcw6f");

            entity.HasOne(d => d.Seg).WithMany(p => p.ModelMasters)
                .HasForeignKey(d => d.SegId)
                .HasConstraintName("FKtpmev85psi1n73w058nmykixb");
        });

        modelBuilder.Entity<SegmentMaster>(entity =>
        {
            entity.HasKey(e => e.SegId).HasName("PRIMARY");

            entity.ToTable("segment_master");

            entity.Property(e => e.SegId).HasColumnName("seg_id");
            entity.Property(e => e.MinQty).HasColumnName("min_qty");
            entity.Property(e => e.SegName)
                .HasMaxLength(255)
                .HasColumnName("seg_name");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("user");

            entity.HasIndex(e => e.Username, "UKsb8bbouer5wak8vyiiy4pf2bx").IsUnique();

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Add1)
                .HasMaxLength(255)
                .HasColumnName("add1");
            entity.Property(e => e.Add2)
                .HasMaxLength(255)
                .HasColumnName("add2");
            entity.Property(e => e.AuthName)
                .HasMaxLength(255)
                .HasColumnName("auth_name");
            entity.Property(e => e.AuthTel)
                .HasMaxLength(255)
                .HasColumnName("auth_tel");
            entity.Property(e => e.Cell)
                .HasMaxLength(255)
                .HasColumnName("cell");
            entity.Property(e => e.City)
                .HasMaxLength(255)
                .HasColumnName("city");
            entity.Property(e => e.CompanyEmail)
                .HasMaxLength(255)
                .HasColumnName("company_email");
            entity.Property(e => e.CompanyName)
                .HasMaxLength(255)
                .HasColumnName("company_name");
            entity.Property(e => e.CompanyStNo)
                .HasMaxLength(255)
                .HasColumnName("company_st_no");
            entity.Property(e => e.CompanyVatNo)
                .HasMaxLength(255)
                .HasColumnName("company_vat_no");
            entity.Property(e => e.Designation)
                .HasMaxLength(255)
                .HasColumnName("designation");
            entity.Property(e => e.Fax)
                .HasMaxLength(255)
                .HasColumnName("fax");
            entity.Property(e => e.HoldingType)
                .HasMaxLength(255)
                .HasColumnName("holding_type");
            entity.Property(e => e.Password)
                .HasMaxLength(255)
                .HasColumnName("password");
            entity.Property(e => e.Phone)
                .HasMaxLength(255)
                .HasColumnName("phone");
            entity.Property(e => e.Pin)
                .HasMaxLength(255)
                .HasColumnName("pin");
            entity.Property(e => e.RegistrationNo)
                .HasMaxLength(255)
                .HasColumnName("registration_no");
            entity.Property(e => e.State)
                .HasMaxLength(255)
                .HasColumnName("state");
            entity.Property(e => e.TaxPan)
                .HasMaxLength(255)
                .HasColumnName("tax_pan");
            entity.Property(e => e.Username).HasColumnName("username");
        });

        modelBuilder.Entity<VehicleDetail>(entity =>
        {
            entity.HasKey(e => e.ConfiId).HasName("PRIMARY");

            entity.ToTable("vehicle_detail");

            entity.HasIndex(e => e.CompId, "FKhih0q8yg3skwicdw9e0kigiti");

            entity.HasIndex(e => e.ModelId, "FKob8nyvm56uj4gbkm8kjdwmole");

            entity.Property(e => e.ConfiId).HasColumnName("confi_id");
            entity.Property(e => e.CompId).HasColumnName("comp_id");
            entity.Property(e => e.CompType)
                .HasColumnType("enum('C','E','I','S')")
                .HasColumnName("comp_type");
            entity.Property(e => e.IsConfigurable).HasColumnName("is_configurable");
            entity.Property(e => e.ModelId).HasColumnName("model_id");

            entity.HasOne(d => d.Comp).WithMany(p => p.VehicleDetails)
                .HasForeignKey(d => d.CompId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKhih0q8yg3skwicdw9e0kigiti");

            entity.HasOne(d => d.Model).WithMany(p => p.VehicleDetails)
                .HasForeignKey(d => d.ModelId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKob8nyvm56uj4gbkm8kjdwmole");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
