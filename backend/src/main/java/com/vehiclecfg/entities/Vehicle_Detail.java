package com.vehiclecfg.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


enum Comp_Type {
	C, S, I, E
}

enum Is_Configurable {
	N, Y
}

@Entity
public class Vehicle_Detail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int confi_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="model_id",nullable=false)
	private Model model;
//	
//	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comp_id",nullable=false)
	private Component component_master;

	private String comp_type;
	private boolean Is_configurable;
	public int getConfi_id() {
		return confi_id;
	}
	public void setConfi_id(int confi_id) {
		this.confi_id = confi_id;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Component getComponent_master() {
		return component_master;
	}
	public void setComponent_master(Component component_master) {
		this.component_master = component_master;
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
