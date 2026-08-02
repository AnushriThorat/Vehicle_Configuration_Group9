package com.vehiclecfg.dto;

public class ComponentDto {

    private Integer compId;
    private String compName;
    private String compType;
    private boolean configurable;

    public ComponentDto() {
    }

    public ComponentDto(Integer compId, String compName, String compType, boolean configurable) {
        this.compId = compId;
        this.compName = compName;
        this.compType = compType;
        this.configurable = configurable;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public boolean isConfigurable() {
        return configurable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }
}