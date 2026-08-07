package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.dto.VehicleDetailsResponseDto;
import com.vehiclecfg.entities.VehicleDetail;
import com.vehiclecfg.services.VehicleDetailService;

@RestController
@RequestMapping("/api/vehicle-details")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class VehicleDetailController {

    @Autowired
    private VehicleDetailService service;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<VehicleDetail> save(
            @RequestBody VehicleDetail vehicleDetail) {

        VehicleDetail savedVehicleDetail =
                service.save(vehicleDetail);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedVehicleDetail);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<VehicleDetail>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetail> getById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                service.getById(id)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDetail> update(
            @PathVariable Integer id,
            @RequestBody VehicleDetail vehicleDetail) {

        VehicleDetail updatedVehicleDetail =
                service.update(id, vehicleDetail);

        return ResponseEntity.ok(updatedVehicleDetail);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

    // ==================== GET VEHICLE DETAILS BY MODEL ====================

    @GetMapping("/model/{modelId}")
    public ResponseEntity<VehicleDetailsResponseDto> getVehicleDetails(
            @PathVariable Integer modelId) {

        VehicleDetailsResponseDto response =
                service.getVehicleDetailsResponse(modelId);

        return ResponseEntity.ok(response);

    }
    
 // ==================== GET CONFIGURABLE VEHICLE DETAILS ====================

    @GetMapping("/model/{modelId}/configurable")
    public ResponseEntity<VehicleDetailsResponseDto> getConfigurableVehicleDetails(
            @PathVariable Integer modelId) {

        VehicleDetailsResponseDto response =
                service.getConfigurableVehicleDetails(modelId);

        return ResponseEntity.ok(response);

    }

}