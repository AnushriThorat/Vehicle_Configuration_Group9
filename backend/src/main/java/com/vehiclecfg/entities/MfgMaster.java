package com.vehiclecfg.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "mfg_master")
public class MfgMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mfg_id")
    private Integer mfg_id;

    @Column(name = "mfg_name")
    private String mfg_name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "seg_id")
    private  Segment segment;


    public Integer getMfgId() {
        return mfg_id;
    }

    public void setMfgId(Integer mfg_id) {
        this.mfg_id = mfg_id;
    }

    public String getMfgName() {
        return mfg_name;
    }

    public void setMfgName(String mfg_name) {
        this.mfg_name = mfg_name;
    }

	public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	
	
}
