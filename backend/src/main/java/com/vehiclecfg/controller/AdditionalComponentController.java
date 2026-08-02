package com.vehiclecfg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.dto.AdditionalComponentDTO;
import com.vehiclecfg.entities.AdditionalComponent;
import com.vehiclecfg.services.AdditionalComponentService;

@RestController
@RequestMapping("/api/additional-components")
@CrossOrigin(origins = "http://localhost:5173")
public class AdditionalComponentController {

    @Autowired
    private AdditionalComponentService service;

    // ==================== POST ====================

    @PostMapping
    public AdditionalComponent save(@RequestBody AdditionalComponent component) {
        return service.save(component);
    }

    // ==================== GET ALL ====================

    @GetMapping
    public List<AdditionalComponent> getAll() {
        return service.getAll();
    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public AdditionalComponent getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public AdditionalComponent update(@PathVariable Integer id,
                                      @RequestBody AdditionalComponent component) {
        return service.update(id, component);
    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        service.delete(id);

        return "Additional Component Deleted Successfully";
    }

    // ==================== GET BY MODEL (Frontend) ====================

    @GetMapping("/model/{modelId}")
    public List<AdditionalComponentDTO> getAdditionalComponentsByModel(
            @PathVariable Integer modelId) {

        List<AdditionalComponent> components = service.getByModel(modelId);

        return components.stream().map(component -> {

            AdditionalComponentDTO dto = new AdditionalComponentDTO();

            dto.setAltId(component.getAltId());

            dto.setModelId(component.getModel().getModelId());

            dto.setCompId(component.getComponent().getCompId());
            dto.setComponentName(component.getComponent().getCompName());

            dto.setAltCompId(component.getAlternateComponent().getCompId());
            dto.setAlternateComponentName(component.getAlternateComponent().getCompName());

            dto.setDeltaPrice(component.getDeltaPrice());
            
            

            return dto;

        }).collect(Collectors.toList());
    }
}