package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Component;
import com.vehiclecfg.repository.ComponentRepository;
import com.vehiclecfg.services.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    private ComponentRepository repository;

    @Override
    public Component save(Component component) {

        if (repository.existsByCompName(component.getCompName())) {
            throw new RuntimeException("Component already exists.");
        }

        return repository.save(component);
    }

    @Override
    public List<Component> getAll() {
        return repository.findAll();
    }

    @Override
    public Component getById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with Id : " + id));
    }

    @Override
    public Component update(Integer id, Component component) {

        Component existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with Id : " + id));

        existing.setCompName(component.getCompName());

        return repository.save(existing);
    }

    @Override
    public void delete(Integer id) {

        Component existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with Id : " + id));

        repository.delete(existing);
    }
}