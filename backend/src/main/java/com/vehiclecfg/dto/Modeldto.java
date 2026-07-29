package com.vehiclecfg.dto;

public class Modeldto {
	
	
	private String model_name;
	private String seg_name;
	
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getSeg_name() {
		return seg_name;
	}
	public void setSeg_name(String seg_name) {
		this.seg_name = seg_name;
	}
	
	public Modeldto(String model_name, String seg_name) {
		super();
		this.model_name = model_name;
		seg_name = seg_name;
	}
	public Modeldto(String model_name) {
		super();
		this.model_name = model_name;
	}

}
