package com.vehiclecfg.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Component;
import com.vehiclecfg.services.ComponentService;

@RestController
@RequestMapping("/components")
public class ComponentController {

    @Autowired
    private ComponentService service;

    @PostMapping
    public Component save(@RequestBody Component component) {
        return service.save(component);
    }

    @GetMapping
    public List<Component> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Component getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Component update(@PathVariable Integer id,
                            @RequestBody Component component) {
        return service.update(id, component);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Component Deleted Successfully";
    }
}