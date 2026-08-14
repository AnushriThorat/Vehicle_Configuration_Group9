package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.MfgMaster;
import com.vehiclecfg.services.MfgService;

@RestController
@RequestMapping("/manufacturers")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class MfgController {

    @Autowired
    private MfgService mfgService;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<MfgMaster> saveManufacturer(
            @RequestBody MfgMaster manufacturer) {

        MfgMaster savedManufacturer =
                mfgService.saveManufacturer(manufacturer);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedManufacturer);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<MfgMaster>> getAllManufacturers() {

        return ResponseEntity.ok(
                mfgService.getAllManufacturers()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<MfgMaster> getManufacturerById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                mfgService.getManufacturerById(id)
        );

    }

    // ==================== GET BY SEGMENT ====================

    @GetMapping("/segment/{segmentId}")
    public ResponseEntity<List<MfgMaster>> getManufacturersBySegment(
            @PathVariable Integer segmentId) {

        return ResponseEntity.ok(
                mfgService.getManufacturersBySegment(segmentId)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<MfgMaster> updateManufacturer(
            @PathVariable Integer id,
            @RequestBody MfgMaster manufacturer) {

        manufacturer.setMfgId(id);

        MfgMaster updatedManufacturer =
                mfgService.updateManufacturer(manufacturer);

        return ResponseEntity.ok(updatedManufacturer);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(
            @PathVariable Integer id) {

        mfgService.deleteManufacturer(id);

        return ResponseEntity.noContent().build();

    }

}