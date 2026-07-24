package com.vehiclecfg.dto;

public class AdditionalComponentDTO {

    private Integer altId;
    private Integer modelId;
    private Integer compId;
    private Integer altCompId;
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

    public Integer getAltCompId() {
        return altCompId;
    }

    public void setAltCompId(Integer altCompId) {
        this.altCompId = altCompId;
    }

    public Double getDeltaPrice() {
        return deltaPrice;
    }

    public void setDeltaPrice(Double deltaPrice) {
        this.deltaPrice = deltaPrice;
    }
}