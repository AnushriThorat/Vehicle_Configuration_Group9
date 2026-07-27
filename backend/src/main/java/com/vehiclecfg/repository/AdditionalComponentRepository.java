package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.AdditionalComponent; 


public interface AdditionalComponentRepository extends JpaRepository<AdditionalComponent, Integer> {

}