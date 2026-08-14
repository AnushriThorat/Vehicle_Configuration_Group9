package com.vehiclecfg.entities;

import jakarta.persistence.*; 

@Entity
@Table(name = "component_master")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private Integer compId;

    @Column(name = "comp_name", nullable = false, unique = true)
    private String compName;

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
}