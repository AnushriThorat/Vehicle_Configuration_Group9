package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Model;

public interface ModelService {

    // Add Model
    Model addModel(Model model);

    // Get All Models
    List<Model> getAllModels();

    // Get Model By Id
    Model getModelById(Integer modelId);

    // Get Models By Manufacturer
    List<Model> getModelsByManufacturer(Integer manufacturerId);

    // Update Model Image
    Model updateImage(Integer modelId, String imagePath);

}