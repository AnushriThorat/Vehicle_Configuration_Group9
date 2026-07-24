package com.vehiclecfg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclecfg.entities.Model;
import com.vehiclecfg.services.ModelService;



@RestController
@RequestMapping("/models")
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	
	  @PostMapping
	    public Model addModel(@RequestBody Model model) {
	        return modelService.addModel(model);
	    }
	  
	  @GetMapping
	    public List<Model> getAllVehicles() {
	        return modelService.getAllModels();
	    }
	  
	  @GetMapping("/{id}")
	    public Model getModelById(@PathVariable Integer modelId) {
	        return modelService.getModelById(modelId);
	    }
	  
//	    @GetMapping("/manufacturer/{manufacturerId}")
//	    public List<Model> getModelsByManufacturer(@PathVariable Integer manufacturerId) {
//	    	return modelService.getModelsByManufacturer(manufacturerId);
//	    }
//
//	    // Get Vehicles By Segment
//	    @GetMapping("/segment/{segmentId}")
//	    public List<Model> getModelsBySegment(
//	            @PathVariable Integer segmentId) {
//
//	        return modelService.getModelsBySegment(segmentId);
//	    }
	  	
//	    @GetMapping("/manufacturer/{manufacturerId}/segment/{segmentId}")
//	    public List<Model> getVehiclesByManufacturerAndSegment(@PathVariable Integer manufacturerId, @PathVariable Integer segmentId){
//
//	        return modelService.getVehiclesByManufacturerAndSegment(segmentId, manufacturerId);
//
//	    }
	  
//	    @GetMapping("/{modelId}/configuration-options")
//	    public ResponseEntity<List<ModelConfigurationDTO>> getConfigurations(@PathVariable ("modelId") Integer modelId, @RequestParam String category) {
//	        List<ModelConfigurationDTO> configurations = modelConfigurationService.getConfigurations(modelId, category);
//	        return ResponseEntity.ok(configurations);
//
//	    }
	  	
	    @PatchMapping("/{id}/image")
	    public Model updateImage(@PathVariable Integer modelId, @RequestBody Map<String, String> request) {
	        return modelService.updateImage(modelId, request.get("imagePath"));
	    }
}
