package com.vehiclecfg.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Model Master")
public class Model {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer modelId;
	
	private String modelName;
	
	// private Segment segment;
	// private Manufacturer manufacturer;
	
	@Column(name = "base_price", precision = 12, scale = 2, nullable = false)
	private BigDecimal basePrice;
	
	private String imagePath;

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

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
