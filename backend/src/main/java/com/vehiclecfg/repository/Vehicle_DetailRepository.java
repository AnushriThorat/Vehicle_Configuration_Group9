package com.vehiclecfg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehiclecfg.entities.Vehicle_Detail;

@Repository
public interface Vehicle_DetailRepository extends JpaRepository<Vehicle_Detail,Integer>
{
	
	 @Query("""
	           SELECT vd
	           FROM Vehicle_Detail vd
	           WHERE vd.model_Master.model_d = :model_id
	           AND vd.Is_configurable = true
	           """)
	    List<Vehicle_Detail> findConfigurableComponentsByModel(
	            @Param("model_id") Integer model_id);

}
