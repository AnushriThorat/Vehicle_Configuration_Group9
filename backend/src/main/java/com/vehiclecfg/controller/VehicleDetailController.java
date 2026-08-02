package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.dto.VehicleDetailsResponseDto;
import com.vehiclecfg.entities.VehicleDetail;
import com.vehiclecfg.services.VehicleDetailService;

@RestController
@RequestMapping("/api/vehicle-details")
public class VehicleDetailController {

    @Autowired
    private VehicleDetailService service;

    @PostMapping
    public VehicleDetail save(@RequestBody VehicleDetail vehicleDetail) {
        return service.save(vehicleDetail);
    }

    @GetMapping
    public List<VehicleDetail> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VehicleDetail getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public VehicleDetail update(@PathVariable Integer id,
                                @RequestBody VehicleDetail vehicleDetail) {
        return service.update(id, vehicleDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.ok("Vehicle Detail Deleted Successfully");
    }
    @GetMapping("/model/{modelId}")
    public VehicleDetailsResponseDto getVehicleDetails(@PathVariable Integer modelId) {
        return service.getVehicleDetailsResponse(modelId);
    }
}