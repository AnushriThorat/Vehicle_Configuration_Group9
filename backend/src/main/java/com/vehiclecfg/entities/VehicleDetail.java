package com.vehiclecfg.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "vehicle_detail")
public class VehicleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confi_id")
    private Integer confiId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comp_id", nullable = false)
    private Component component;

    @Enumerated(EnumType.STRING)
    @Column(name = "comp_type", nullable = false)
    private CompType compType;

    @Column(name = "is_configurable", nullable = false)
    private boolean configurable;

    public VehicleDetail() {
    }

    public Integer getConfiId() {
        return confiId;
    }

    public void setConfiId(Integer confiId) {
        this.confiId = confiId;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public CompType getCompType() {
        return compType;
    }

    public void setCompType(CompType compType) {
        this.compType = compType;
    }

    public boolean isConfigurable() {
        return configurable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }
}