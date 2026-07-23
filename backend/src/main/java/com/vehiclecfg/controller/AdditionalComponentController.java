package com.vehiclecfg.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.AdditionalComponent;
import com.vehiclecfg.services.AdditionalComponentService;

@RestController
@RequestMapping("/additional-component")
public class AdditionalComponentController {

    @Autowired
    private AdditionalComponentService service;

    @PostMapping
    public AdditionalComponent save(@RequestBody AdditionalComponent component) {
        return service.save(component);
    }

    @GetMapping
    public List<AdditionalComponent> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AdditionalComponent getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AdditionalComponent update(@PathVariable Integer id,
                                      @RequestBody AdditionalComponent component) {
        return service.update(id, component);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}