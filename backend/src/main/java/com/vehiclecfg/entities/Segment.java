package com.vehiclecfg.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Segment_Master")
public class Segment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Seg_id")
	private int seg_id;
	
	@Column(name = "Seg_name")
	private String seg_name;
	
	@Column(name = "min_Qty")
	private int minQty;
	
	
	public int getSeg_id() {
		return seg_id;
	}
	public void setSeg_id(int seg_id) {
		this.seg_id = seg_id;
	}
	public String getSeg_name() {
		return seg_name;
	}
	public void setSeg_name(String seg_name) {
		this.seg_name = seg_name;
	}
	public int getMinQty() {
		return minQty;
	}
	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}
}