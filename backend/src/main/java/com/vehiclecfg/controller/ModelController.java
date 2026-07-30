package com.vehiclecfg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Model;
import com.vehiclecfg.services.ModelService;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    // Add Model
    @PostMapping
    public Model addModel(@RequestBody Model model) {
        return modelService.addModel(model);
    }

    // Get All Models
    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    // Get Model By Id
    @GetMapping("/{id}")
    public Model getModelById(@PathVariable("id") Integer modelId) {
        return modelService.getModelById(modelId);
    }

    // Get Models By Manufacturer
    @GetMapping("/manufacturer/{manufacturerId}")
    public List<Model> getModelsByManufacturer(@PathVariable Integer manufacturerId) {
        return modelService.getModelsByManufacturer(manufacturerId);
    }

    // Update Model Image
    @PatchMapping("/{id}/image")
    public Model updateImage(@PathVariable("id") Integer modelId,
                             @RequestBody Map<String, String> request) {

        return modelService.updateImage(modelId, request.get("imagePath"));
    }
}