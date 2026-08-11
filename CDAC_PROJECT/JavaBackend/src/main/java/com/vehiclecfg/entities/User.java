package com.vehiclecfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "holding_type")
    private String holdingType;

    @Column(name = "add1")
    private String address1;

    @Column(name = "add2")
    private String address2;

    private String city;

    private String state;

    private String pin;

    @Column(name = "auth_name")
    private String authorizedPersonName;

    private String designation;

    @Column(name = "auth_tel")
    private String authPersonTel;

    private String cell;

    private String phone;

    private String fax;

    @Column(name = "company_st_no")
    private String companyStNo;

    @Column(name = "company_vat_no")
    private String companyVatNo;

    @Column(name = "tax_pan")
    private String taxPan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getHoldingType() {
		return holdingType;
	}

	public void setHoldingType(String holdingType) {
		this.holdingType = holdingType;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAuthorizedPersonName() {
		return authorizedPersonName;
	}

	public void setAuthorizedPersonName(String authorizedPersonName) {
		this.authorizedPersonName = authorizedPersonName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAuthPersonTel() {
		return authPersonTel;
	}

	public void setAuthPersonTel(String authPersonTel) {
		this.authPersonTel = authPersonTel;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCompanyStNo() {
		return companyStNo;
	}

	public void setCompanyStNo(String companyStNo) {
		this.companyStNo = companyStNo;
	}

	public String getCompanyVatNo() {
		return companyVatNo;
	}

	public void setCompanyVatNo(String companyVatNo) {
		this.companyVatNo = companyVatNo;
	}

	public String getTaxPan() {
		return taxPan;
	}

	public void setTaxPan(String taxPan) {
		this.taxPan = taxPan;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", companyName=" + companyName
				+ ", companyEmail=" + companyEmail + ", registrationNo=" + registrationNo + ", holdingType="
				+ holdingType + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", pin=" + pin + ", authorizedPersonName=" + authorizedPersonName + ", designation="
				+ designation + ", authPersonTel=" + authPersonTel + ", cell=" + cell + ", phone=" + phone + ", fax="
				+ fax + ", companyStNo=" + companyStNo + ", companyVatNo=" + companyVatNo + ", taxPan=" + taxPan + "]";
	}
    
}