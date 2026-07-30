package com.vehiclecfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.vehiclecfg.entities.MfgMaster;


public interface MfgRepository extends JpaRepository<MfgMaster,Integer>{
	List<MfgMaster> findBySegmentSegId(Integer segmentId);;
}
