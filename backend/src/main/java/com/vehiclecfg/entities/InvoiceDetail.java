package com.vehiclecfg.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="invoice_detail")
public class InvoiceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invdtl_id;

	
	@Column(name = "inv_id")
	private Integer inv_id;
	
	
	@Column(name = "comp_id")
	private Integer comp_id;
	
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

	public Integer getComp_id() {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	

		
	
}
