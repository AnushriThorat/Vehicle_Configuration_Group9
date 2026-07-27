package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.Model;


public interface ModelRepository extends JpaRepository<Model, Integer> {

	boolean existsByModelName(String modelName);
	
	//List<Model> findByManufacturer(Manufacturer manufacturer);

    //List<Model> findBySegment(Segment segment);
   
    //List<Model> findByManufacturerId(Integer manufacturerId);
    
    //List<Manufacturer> getManufacturersBySegment(Integer segmentId);
	
//	@Query("""
//            SELECT v FROM Vehicle v
//            WHERE v.segment.id=:segmentId
//            AND v.manufacturer.id=:manufacturerId
//            """)
//    List<Model> getModelsByManufacturerAndSegment(@Param("segmentId") Integer segmentId,@Param("manufacturerId") Integer manufacturerId);
}
