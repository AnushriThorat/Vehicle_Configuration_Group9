package com.vehiclecfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vehiclecfg.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Model m WHERE m.modelName = :modelName")
    boolean existsModelName(@Param("modelName") String modelName);

    List<Model> findByMfgmasterMfgId(Integer manufacturerId);
}