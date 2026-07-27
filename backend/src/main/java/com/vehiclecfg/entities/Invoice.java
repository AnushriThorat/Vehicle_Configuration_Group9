package com.vehiclecfg.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inv_id;

    private Date inv_date;

  @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="model_id",nullable=false)
	private Model model;


  @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id",nullable=false)
	private User user;
   

    private Double totalAmt;      // Vehicle amount
     
    private Double tax;
    private Double netAmt;
	public Long getInv_id() {
		return inv_id;
	}
	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}
	public Date getInv_date() {
		return inv_date;
	}
	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public User getUser_id() {
		return user;
	}
	public void setUser_id(User user_id) {
		this.user = user_id;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
	}

 
}
    

