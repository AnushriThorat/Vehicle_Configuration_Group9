package com.vehiclecfg.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Model_Master")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;

    @Column(name = "model_name")
    private String modelName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seg_id")
    private Segment segment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mfg_id")
    private MfgMaster mfgmaster;
    
    @Column(name = "base_price", precision = 12, scale = 2, nullable = false)
    private BigDecimal basePrice;

    @Column(name = "image_path")
    private String imagePath;

    // Default Constructor
    public Model() {
    }

    // Getters and Setters

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

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public MfgMaster getMfgmaster() {
        return mfgmaster;
    }

    public void setMfgmaster(MfgMaster mfgmaster) {
        this.mfgmaster = mfgmaster;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}