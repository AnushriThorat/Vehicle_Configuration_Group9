using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace DotNetBackend.Models;

[Table("user")]
[Index("Username", Name = "UKsb8bbouer5wak8vyiiy4pf2bx", IsUnique = true)]
public partial class User
{
    [Key]
    [Column("id")]
    public int Id { get; set; }

    [Column("add1")]
    [StringLength(255)]
    public string? Add1 { get; set; }

    [Column("add2")]
    [StringLength(255)]
    public string? Add2 { get; set; }

    [Column("auth_tel")]
    [StringLength(255)]
    public string? AuthTel { get; set; }

    [Column("auth_name")]
    [StringLength(255)]
    public string? AuthName { get; set; }

    [Column("cell")]
    [StringLength(255)]
    public string? Cell { get; set; }

    [Column("city")]
    [StringLength(255)]
    public string? City { get; set; }

    [Column("company_email")]
    [StringLength(255)]
    public string? CompanyEmail { get; set; }

    [Column("company_name")]
    [StringLength(255)]
    public string? CompanyName { get; set; }

    [Column("company_st_no")]
    [StringLength(255)]
    public string? CompanyStNo { get; set; }

    [Column("company_vat_no")]
    [StringLength(255)]
    public string? CompanyVatNo { get; set; }

    [Column("designation")]
    [StringLength(255)]
    public string? Designation { get; set; }

    [Column("fax")]
    [StringLength(255)]
    public string? Fax { get; set; }

    [Column("holding_type")]
    [StringLength(255)]
    public string? HoldingType { get; set; }

    [Column("password")]
    [StringLength(255)]
    public string Password { get; set; } = null!;

    [Column("phone")]
    [StringLength(255)]
    public string? Phone { get; set; }

    [Column("pin")]
    [StringLength(255)]
    public string? Pin { get; set; }

    [Column("registration_no")]
    [StringLength(255)]
    public string? RegistrationNo { get; set; }

    [Column("state")]
    [StringLength(255)]
    public string? State { get; set; }

    [Column("tax_pan")]
    [StringLength(255)]
    public string? TaxPan { get; set; }

    [Column("username")]
    public string Username { get; set; } = null!;

    [InverseProperty("IdNavigation")]
    public virtual ICollection<Invoice> Invoices { get; set; } = new List<Invoice>();
}
