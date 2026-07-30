package com.vehiclecfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mfg_master")
public class MfgMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mfg_id")
    private Integer mfgId;

    @Column(name = "mfg_name")
    private String mfgName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seg_id")
    private Segment segment;

    // Default Constructor
    public MfgMaster() {
    }

    // Getters and Setters

    public Integer getMfgId() {
        return mfgId;
    }

    public void setMfgId(Integer mfgId) {
        this.mfgId = mfgId;
    }

    public String getMfgName() {
        return mfgName;
    }

    public void setMfgName(String mfgName) {
        this.mfgName = mfgName;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }
}