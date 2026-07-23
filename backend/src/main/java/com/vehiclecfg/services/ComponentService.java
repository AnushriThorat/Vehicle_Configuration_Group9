package com.vehiclecfg.services;

import java.util.List; 

import com.vehiclecfg.entities.Component;

public interface ComponentService {

    Component save(Component component);

    List<Component> getAll();

    Component getById(Integer id);

    Component update(Integer id, Component component);

    void delete(Integer id);
}