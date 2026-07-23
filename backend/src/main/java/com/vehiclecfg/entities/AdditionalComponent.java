package com.vehiclecfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alternate_component_master")
public class AdditionalComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id")
    private Integer altId;

    @Column(name = "model_id")
    private Integer modelId;

    @Column(name = "comp_id")
    private Integer compId;

    @Column(name = "alt_comp_id")
    private Integer altCompId;

    @Column(name = "delta_price")
    private Double deltaPrice;

    public AdditionalComponent() {
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