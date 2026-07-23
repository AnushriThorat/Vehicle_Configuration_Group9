package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.Component; 
public interface ComponentRepository extends JpaRepository<Component, Integer> {

}