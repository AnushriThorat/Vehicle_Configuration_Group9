package com.vehiclecfg.entities;

import jakarta.persistence.*;

enum CompType {
    C, S, I, E
}

@Entity
@Table(name = "vehicle_detail")
public class Vehicle_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confi_id")
    private Integer confiId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_id", nullable = false)
    private Component componentMaster;

    @Enumerated(EnumType.STRING)
    @Column(name = "comp_type")
    private CompType compType;

    @Column(name = "is_configurable")
    private boolean configurable;

    // Default Constructor
    public Vehicle_Detail() {
    }

    // Getters and Setters

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

    public Component getComponentMaster() {
        return componentMaster;
    }

    public void setComponentMaster(Component componentMaster) {
        this.componentMaster = componentMaster;
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