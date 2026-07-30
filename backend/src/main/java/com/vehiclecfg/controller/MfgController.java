package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.MfgMaster;
import com.vehiclecfg.services.MfgService;

@RestController
@RequestMapping("/manufacturers")
public class MfgController {

    @Autowired
    private MfgService mfgService;

    // Save Manufacturer
    @PostMapping
    public MfgMaster saveManufacturer(@RequestBody MfgMaster manufacturer) {
        return mfgService.saveManufacturer(manufacturer);
    }

    // Get All Manufacturers
    @GetMapping
    public List<MfgMaster> getAllManufacturers() {
        return mfgService.getAllManufacturers();
    }

    // Get Manufacturer By Id
    @GetMapping("/{id}")
    public MfgMaster getManufacturerById(@PathVariable Integer id) {
        return mfgService.getManufacturerById(id);
    }

    // Get Manufacturers By Segment
    @GetMapping("/segment/{segmentId}")
    public List<MfgMaster> getManufacturersBySegment(@PathVariable Integer segmentId) {
        return mfgService.getManufacturersBySegment(segmentId);
    }

    // Update Manufacturer
    @PutMapping("/{id}")
    public MfgMaster updateManufacturer(@PathVariable Integer id,
                                        @RequestBody MfgMaster manufacturer) {
        manufacturer.setMfgId(id);
        return mfgService.updateManufacturer(manufacturer);
    }

    // Delete Manufacturer
    @DeleteMapping("/{id}")
    public String deleteManufacturer(@PathVariable Integer id) {
        mfgService.deleteManufacturer(id);
        return "Manufacturer Deleted Successfully";
    }
}