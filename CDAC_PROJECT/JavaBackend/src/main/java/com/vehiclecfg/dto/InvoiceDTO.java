package com.vehiclecfg.dto;

import java.util.Date;

public class InvoiceDTO {

    private Long invId;

    private Date invDate;

    private Integer modelId;

    private Integer userId;

    private Double totalAmt;

    private Double tax;

    private Double netAmt;

    public InvoiceDTO() {
    }

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(Double netAmt) {
        this.netAmt = netAmt;
    }

}