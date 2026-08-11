package com.vehiclecfg.dto;

public class AdditionalComponentDTO {

    private Integer altId;
    private Integer modelId;

    private Integer compId;
    private String componentName;
    private String componentType;

    private Integer altCompId;
    private String alternateComponentName;

    private Double deltaPrice;

    public AdditionalComponentDTO() {
    }

    public Integer getAltId() {
        return altId;
    }

    public void setAltId(Integer altId) {
        this.altId = altId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Integer getAltCompId() {
        return altCompId;
    }

    public void setAltCompId(Integer altCompId) {
        this.altCompId = altCompId;
    }

    public String getAlternateComponentName() {
        return alternateComponentName;
    }

    public void setAlternateComponentName(String alternateComponentName) {
        this.alternateComponentName = alternateComponentName;
    }

    public Double getDeltaPrice() {
        return deltaPrice;
    }

    public void setDeltaPrice(Double deltaPrice) {
        this.deltaPrice = deltaPrice;
    }
}