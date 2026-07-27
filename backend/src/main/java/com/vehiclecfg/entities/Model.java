package com.vehiclecfg.entities;

import java.math.BigDecimal;

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
@Table(name = "Model Master")
public class Model {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer model_id;
	
	private String modelName;
	
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="seg_id")
	 private Segment segment;
	 
	 public Integer getModel_id() {
		return model_id;
	}

	 public void setModel_id(Integer model_id) {
		 this.model_id = model_id;
	 }

	

	 public String getModelName() {
		return modelName;
	}

	 public void setModelName(String modelName) {
		 this.modelName = modelName;
	 }

	 public Segment getSegment() {
		return segment;
	}

	 public void setSegment(Segment segment) {
		 this.segment = segment;
	 }

	 public MfgMaster getMfgmaster() {
		 return mfgmaster;
	 }

	 public void setMfgmaster(MfgMaster mfgmaster) {
		 this.mfgmaster = mfgmaster;
	 }

	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="mfg_id")
	 private MfgMaster mfgmaster;
	
	@Column(name = "base_price", precision = 12, scale = 2, nullable = false)
	private BigDecimal basePrice;
	
	private String imagePath;


	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
