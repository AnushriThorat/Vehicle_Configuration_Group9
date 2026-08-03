package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.AdditionalComponent;
import com.vehiclecfg.exception.ComponentNotFoundException;
import com.vehiclecfg.repository.AdditionalComponentRepository;
import com.vehiclecfg.services.AdditionalComponentService;

@Service
public class AdditionalComponentServiceImpl implements AdditionalComponentService {

    @Autowired
    private AdditionalComponentRepository repository;

    @Override
    public AdditionalComponent save(AdditionalComponent component) {

        return repository.save(component);

    }

    @Override
    public List<AdditionalComponent> getAll() {

        return repository.findAll();

    }

    @Override
    public AdditionalComponent getById(Integer id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new ComponentNotFoundException(

                                "Additional Component not found with ID : " + id

                        )

                );

    }

    @Override
    public AdditionalComponent update(Integer id, AdditionalComponent component) {

        AdditionalComponent existing = repository.findById(id)

                .orElseThrow(() ->

                        new ComponentNotFoundException(

                                "Additional Component not found with ID : " + id

                        )

                );

        existing.setModel(component.getModel());

        existing.setComponent(component.getComponent());

        existing.setAlternateComponent(component.getAlternateComponent());

        existing.setDeltaPrice(component.getDeltaPrice());

        return repository.save(existing);

    }

    @Override
    public void delete(Integer id) {

        if (!repository.existsById(id)) {

            throw new ComponentNotFoundException(

                    "Additional Component not found with ID : " + id

            );

        }

        repository.deleteById(id);

    }

    @Override
    public List<AdditionalComponent> getByModel(Integer modelId) {

        return repository.findByModelModelId(modelId);

    }

}