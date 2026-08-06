package com.vehiclecfg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehiclecfg.entities.VehicleDetail;

@Repository
public interface VehicleDetailRepository extends JpaRepository<VehicleDetail, Integer> {

    List<VehicleDetail> findByModelModelId(Integer modelId);
    List<VehicleDetail> findByModelModelIdAndConfigurableTrue(Integer modelId);
}