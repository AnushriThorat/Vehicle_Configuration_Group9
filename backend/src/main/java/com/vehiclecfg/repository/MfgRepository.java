package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.vehiclecfg.entities.MfgMaster;


public interface MfgRepository extends JpaRepository<MfgMaster,Integer>{

}
