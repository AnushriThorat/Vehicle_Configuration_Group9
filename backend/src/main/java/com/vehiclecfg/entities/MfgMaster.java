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

    @ManyToOne
    @JoinColumn(name = "seg_id")
    private  int seg_id;


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

	public int getSeg_id() {
		return seg_id;
	}

	public void setSeg_id(int seg_id) {
		this.seg_id = seg_id;
	}

    
	
}
