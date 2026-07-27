package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.AdditionalComponent; 


public interface AdditionalComponentService {

    AdditionalComponent save(AdditionalComponent component);

    List<AdditionalComponent> getAll();

    AdditionalComponent getById(Integer id);

    AdditionalComponent update(Integer id, AdditionalComponent component);

    void delete(Integer id);

}