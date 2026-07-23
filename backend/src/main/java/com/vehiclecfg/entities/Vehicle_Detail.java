package com.vehiclecfg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle_Detail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Confi_id;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="model_id",nullable=false)
//	private Model_Master model_master;
//	
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="comp_id",nullable=false)
//	private Component_Master component_master;
//	
	
	private int model_id;
	private int comp_id;
	private String comp_type;
	private boolean Is_configurable;
	
	
	public int getConfi_id() {
		return Confi_id;
	}
	public void setConfi_id(int confi_id) {
		Confi_id = confi_id;
	}
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_type() {
		return comp_type;
	}
	public void setComp_type(String comp_type) {
		this.comp_type = comp_type;
	}
	public boolean isIs_configurable() {
		return Is_configurable;
	}
	public void setIs_configurable(boolean is_configurable) {
		Is_configurable = is_configurable;
	}
	
}
