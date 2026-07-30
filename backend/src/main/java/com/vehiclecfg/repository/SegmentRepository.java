package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.Segment;

public interface SegmentRepository extends JpaRepository<Segment,Integer>{
	
}
