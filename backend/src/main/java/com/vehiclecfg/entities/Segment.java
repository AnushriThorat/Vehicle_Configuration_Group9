package com.vehiclecfg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Segment_Master")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Seg_id")
    private int segId;

    @Column(name = "Seg_name")
    private String segName;

    @Column(name = "min_Qty")
    private int minQty;

    public int getSegId() {
        return segId;
    }

    public void setSegId(int segId) {
        this.segId = segId;
    }

    public String getSegName() {
        return segName;
    }

    public void setSegName(String segName) {
        this.segName = segName;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
}