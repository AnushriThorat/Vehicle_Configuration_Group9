package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Component;
import com.vehiclecfg.services.ComponentService;

@RestController
@RequestMapping("/components")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class ComponentController {

    @Autowired
    private ComponentService service;

    // ==================== POST ====================

    @PostMapping
    public ResponseEntity<Component> save(
            @RequestBody Component component) {

        Component savedComponent = service.save(component);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedComponent);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<Component>> getAll() {

        return ResponseEntity.ok(service.getAll());

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<Component> getById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                service.getById(id)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<Component> update(
            @PathVariable Integer id,
            @RequestBody Component component) {

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

}