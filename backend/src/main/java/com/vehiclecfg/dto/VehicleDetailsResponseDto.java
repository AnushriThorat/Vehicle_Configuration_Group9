package com.vehiclecfg.dto;

import java.math.BigDecimal;

import java.util.List;

public class VehicleDetailsResponseDto {

    private Integer modelId;
    private String modelName;
    private String imagePath;
    private BigDecimal basePrice;
    private Integer mfgId;
    private String mfgName;

    private Integer segId;
    public Integer getMfgId() {
		return mfgId;
	}

	public void setMfgId(Integer mfgId) {
		this.mfgId = mfgId;
	}

	public String getMfgName() {
		return mfgName;
	}

	public void setMfgName(String mfgName) {
		this.mfgName = mfgName;
	}

	public Integer getSegId() {
		return segId;
	}

	public void setSegId(Integer segId) {
		this.segId = segId;
	}

	public String getSegName() {
		return segName;
	}

	public void setSegName(String segName) {
		this.segName = segName;
	}

	private String segName;

    private List<ComponentDto> coreComponents;
    private List<ComponentDto> interiorComponents;
    private List<ComponentDto> exteriorComponents;
    private List<ComponentDto> standardComponents;

    public VehicleDetailsResponseDto() {
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public List<ComponentDto> getCoreComponents() {
        return coreComponents;
    }

    public void setCoreComponents(List<ComponentDto> coreComponents) {
        this.coreComponents = coreComponents;
    }

    public List<ComponentDto> getInteriorComponents() {
        return interiorComponents;
    }

    public void setInteriorComponents(List<ComponentDto> interiorComponents) {
        this.interiorComponents = interiorComponents;
    }

    public List<ComponentDto> getExteriorComponents() {
        return exteriorComponents;
    }

    public void setExteriorComponents(List<ComponentDto> exteriorComponents) {
        this.exteriorComponents = exteriorComponents;
    }

    public List<ComponentDto> getStandardComponents() {
        return standardComponents;
    }

    public void setStandardComponents(List<ComponentDto> standardComponents) {
        this.standardComponents = standardComponents;
    }
}