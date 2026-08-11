package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Model;
import com.vehiclecfg.exception.ModelNotFoundException;
import com.vehiclecfg.repository.ModelRepository;
import com.vehiclecfg.services.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model addModel(Model model) {

        if (modelRepository.existsModelName(model.getModelName())) {

            throw new RuntimeException(
                    "Model already exists with name : "
                            + model.getModelName()
            );

        }

        return modelRepository.save(model);

    }

    @Override
    public List<Model> getAllModels() {

        return modelRepository.findAll();

    }

    @Override
    public Model getModelById(Integer modelId) {

        return modelRepository.findById(modelId)

                .orElseThrow(() ->

                        new ModelNotFoundException(

                                "Model not found with ID : " + modelId

                        )

                );

    }

    @Override
    public List<Model> getModelsByManufacturer(Integer manufacturerId) {

        return modelRepository.findByMfgmasterMfgId(manufacturerId);

    }

    @Override
    public Model updateImage(Integer modelId, String imagePath) {

        Model model = modelRepository.findById(modelId)

                .orElseThrow(() ->

                        new ModelNotFoundException(

                                "Model not found with ID : " + modelId

                        )

                );

        model.setImagePath(imagePath);

        return modelRepository.save(model);

    }

}