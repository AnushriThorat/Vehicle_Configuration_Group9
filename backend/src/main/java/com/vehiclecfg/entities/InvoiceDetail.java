package com.vehiclecfg.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="invoice_detail")
public class InvoiceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invdtl_id;

	
	@Column(name = "inv_id")
	private Integer inv_id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
	private Component component;

	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id", referencedColumnName = "model_id")
	private Model model;

	public InvoiceDetail() {
		
	}

	public Integer getInvdtl_id() {
		return invdtl_id;
	}

	public Integer getInv_id() {
		return inv_id;
	}

	public void setInv_id(Integer inv_id) {
		this.inv_id = inv_id;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setInvdtl_id(Integer invdtl_id) {
		this.invdtl_id = invdtl_id;
	}

	

	
	
}
