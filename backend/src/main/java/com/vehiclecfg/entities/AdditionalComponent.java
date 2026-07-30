package com.vehiclecfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alternate_component_master")
public class AdditionalComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id")
    private Integer altId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="model_id",nullable=false)
    private Model model;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="comp_id",nullable=false)
    private Component component;
    
    
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