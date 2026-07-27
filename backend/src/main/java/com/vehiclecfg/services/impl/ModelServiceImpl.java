package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vehiclecfg.entities.Model;
import com.vehiclecfg.repository.ModelRepository;
import com.vehiclecfg.services.ModelService;



public class ModelServiceImpl implements ModelService {
	
	@Autowired
	private ModelRepository modelRepository;

	@Override
	public Model addModel(Model model) {

		if (modelRepository.existsByModelName(model.getModelName())) {
            return null;
        }
		
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getAllModels() {
		
		return modelRepository.findAll();
	}

	@Override
	public Model getModelById(Integer modelId) {
		
		return modelRepository.findById(modelId).orElse(null);
	}
	
//    public List<Model> getVehiclesByManufacturerAndSegment(Integer segmentId, Integer manufacturerId){
//        return modelRepository.getVehiclesByManufacturerAndSegment(segmentId,manufacturerId);
//    }
	
//    @Override
//    public List<Model> getModelsByManufacturer(Integer manufacturerId) {
//
//        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElse(null);
//
//        if (manufacturer != null) {
//
//            return modelRepository.findByManufacturerId(manufacturerId);
//        }
//
//        return List.of();
//    }
	
//-----------------------------------------------------------------------------------------------
	
//    @Override
//    public List<Model> getModelsBySegment(Integer segmentId) {
//
//        Segment segment = segmentRepository.findById(segmentId).orElse(null);
//
//        if (segment != null) {
//
//            return modelRepository.findBySegment(segment);
//
//        }
//
//        return List.of();
//    }

	@Override
	public Model updateImage(Integer modelId, String imagePath) {
		Model model = modelRepository.findById(modelId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        model.setImagePath(imagePath);
        return modelRepository.save(model);
	}

}
