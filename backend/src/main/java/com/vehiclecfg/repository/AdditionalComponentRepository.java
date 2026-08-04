package com.vehiclecfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehiclecfg.entities.AdditionalComponent;

@Repository
public interface AdditionalComponentRepository extends JpaRepository<AdditionalComponent, Integer> {

    List<AdditionalComponent> findByModelModelId(Integer modelId);

}