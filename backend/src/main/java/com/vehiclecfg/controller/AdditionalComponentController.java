package com.vehiclecfg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AdditionalComponent> save(
            @RequestBody AdditionalComponent component) {

        AdditionalComponent savedComponent = service.save(component);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedComponent);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<AdditionalComponent>> getAll() {

        return ResponseEntity.ok(service.getAll());

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<AdditionalComponent> getById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.getById(id));

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<AdditionalComponent> update(
            @PathVariable Integer id,
            @RequestBody AdditionalComponent component) {

        return ResponseEntity.ok(
                service.update(id, component)
        );

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

    // ==================== GET BY MODEL ====================

    @GetMapping("/model/{modelId}")
    public ResponseEntity<List<AdditionalComponentDTO>> getAdditionalComponentsByModel(
            @PathVariable Integer modelId) {

        List<AdditionalComponent> components =
                service.getByModel(modelId);

        List<AdditionalComponentDTO> dtoList = components.stream()

                .map(component -> {

                    AdditionalComponentDTO dto =
                            new AdditionalComponentDTO();

                    dto.setAltId(component.getAltId());

                    dto.setModelId(
                            component.getModel().getModelId()
                    );

                    dto.setCompId(
                            component.getComponent().getCompId()
                    );

                    dto.setComponentName(
                            component.getComponent().getCompName()
                    );

                    dto.setAltCompId(
                            component.getAlternateComponent().getCompId()
                    );

                    dto.setAlternateComponentName(
                            component.getAlternateComponent().getCompName()
                    );

                    dto.setDeltaPrice(
                            component.getDeltaPrice()
                    );

                    return dto;

                })

                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);

    }

}