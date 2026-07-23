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
        return repository.save(component);
    }

    @Override
    public List<Component> getAll() {
        return repository.findAll();
    }

    @Override
    public Component getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Component update(Integer id, Component component) {

        Component existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setCompName(component.getCompName());
            existing.setCompType(component.getCompType());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}