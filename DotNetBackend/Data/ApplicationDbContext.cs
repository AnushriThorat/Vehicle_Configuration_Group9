using System;
using System.Collections.Generic;
using DotNetBackend.Models;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Data;

public partial class ApplicationDbContext : DbContext
{
    public ApplicationDbContext()
    {
    }

    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
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

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<AlternateComponentMaster>(entity =>
        {
            entity.HasKey(e => e.AltId).HasName("PRIMARY");

            entity.HasOne(d => d.AltComp).WithMany(p => p.AlternateComponentMasterAltComps).HasConstraintName("FKnnmfalcksg51qu0o4quupn69h");

            entity.HasOne(d => d.Comp).WithMany(p => p.AlternateComponentMasterComps)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKpgv8oj5ulg440a3vrcefmyp24");

            entity.HasOne(d => d.Model).WithMany(p => p.AlternateComponentMasters)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKqcb29n3rowc4mio33w5t3770b");
        });

        modelBuilder.Entity<ComponentMaster>(entity =>
        {
            entity.HasKey(e => e.CompId).HasName("PRIMARY");
        });

        modelBuilder.Entity<Invoice>(entity =>
        {
            entity.HasKey(e => e.InvId).HasName("PRIMARY");

            entity.HasOne(d => d.IdNavigation).WithMany(p => p.Invoices)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK1wpyuwr7s4xc9wbjywkbril9c");

            entity.HasOne(d => d.Model).WithMany(p => p.Invoices)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKarg94e2qrxsjeet2tdq8h3nbb");
        });

        modelBuilder.Entity<InvoiceDetail>(entity =>
        {
            entity.HasKey(e => e.InvdtlId).HasName("PRIMARY");

            entity.HasOne(d => d.AltComp).WithMany(p => p.InvoiceDetailAltComps)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK5vlnmeqvs94aljq9o3yj8a8jo");

            entity.HasOne(d => d.Comp).WithMany(p => p.InvoiceDetailComps)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK9yfk9n3n5le7e7nnq939ybv4r");

            entity.HasOne(d => d.Inv).WithMany(p => p.InvoiceDetails)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKckt5u57libgdv8ot4vq1o46sr");

            entity.HasOne(d => d.Model).WithMany(p => p.InvoiceDetails)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK8hkdrod8r0uqyviryvlgslhb8");
        });

        modelBuilder.Entity<MfgMaster>(entity =>
        {
            entity.HasKey(e => e.MfgId).HasName("PRIMARY");

            entity.HasOne(d => d.Seg).WithMany(p => p.MfgMasters).HasConstraintName("FKok5qd64lq1asv75hpfgpwhdyq");
        });

        modelBuilder.Entity<ModelMaster>(entity =>
        {
            entity.HasKey(e => e.ModelId).HasName("PRIMARY");

            entity.HasOne(d => d.Mfg).WithMany(p => p.ModelMasters).HasConstraintName("FKacbx0rmpiqwgiisi06lsfcw6f");

            entity.HasOne(d => d.Seg).WithMany(p => p.ModelMasters).HasConstraintName("FKtpmev85psi1n73w058nmykixb");
        });

        modelBuilder.Entity<SegmentMaster>(entity =>
        {
            entity.HasKey(e => e.SegId).HasName("PRIMARY");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");
        });

        modelBuilder.Entity<VehicleDetail>(entity =>
        {
            entity.HasKey(e => e.ConfiId).HasName("PRIMARY");

            entity.HasOne(d => d.Comp).WithMany(p => p.VehicleDetails)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKhih0q8yg3skwicdw9e0kigiti");

            entity.HasOne(d => d.Model).WithMany(p => p.VehicleDetails)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKob8nyvm56uj4gbkm8kjdwmole");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
