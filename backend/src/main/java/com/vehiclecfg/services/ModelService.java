package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Model;



public interface ModelService {
	
	Model addModel(Model model);
	
	List<Model> getAllModels();
	
	Model getModelById(Integer modelId);
	
	//List<Model> getModelsByManufacturer(Integer manufacturerId);

    //List<Model> getVehiclesBySegment(Integer segmentId);
    
    // List<Vehicle> getVehiclesByManufacturerAndSegment(Integer segmentId,Integer manufacturerId);
    
	Model updateImage(Integer modelId, String imagePath);
}
