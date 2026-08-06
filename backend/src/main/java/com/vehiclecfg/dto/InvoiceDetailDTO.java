package com.vehiclecfg.dto;

public class InvoiceDetailDTO {

    private Integer invdtlId;

    private Long invoiceId;

    private Integer modelId;

    private Integer compId;

    private String componentName;

    private Integer altCompId;

    private String alternateComponentName;

    private Double deltaPrice;

    public InvoiceDetailDTO() {
    }

    public Integer getInvdtlId() {
        return invdtlId;
    }

    public void setInvdtlId(Integer invdtlId) {
        this.invdtlId = invdtlId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
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