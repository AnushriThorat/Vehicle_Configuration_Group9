package com.vehiclecfg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Model;
import com.vehiclecfg.services.ModelService;

@RestController
@RequestMapping("/models")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class ModelController {

    @Autowired
    private ModelService modelService;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<Model> addModel(
            @RequestBody Model model) {

        Model savedModel =
                modelService.addModel(model);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedModel);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<Model>> getAllModels() {

        return ResponseEntity.ok(
                modelService.getAllModels()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(
            @PathVariable("id") Integer modelId) {

        return ResponseEntity.ok(
                modelService.getModelById(modelId)
        );

    }

    // ==================== GET BY MANUFACTURER ====================

    @GetMapping("/manufacturer/{manufacturerId}")
    public ResponseEntity<List<Model>> getModelsByManufacturer(
            @PathVariable Integer manufacturerId) {

        return ResponseEntity.ok(
                modelService.getModelsByManufacturer(manufacturerId)
        );

    }

    // ==================== UPDATE IMAGE ====================

    @PatchMapping("/{id}/image")
    public ResponseEntity<Model> updateImage(
            @PathVariable("id") Integer modelId,
            @RequestBody Map<String, String> request) {

        Model updatedModel =
                modelService.updateImage(
                        modelId,
                        request.get("imagePath")
                );

        return ResponseEntity.ok(updatedModel);

    }

}