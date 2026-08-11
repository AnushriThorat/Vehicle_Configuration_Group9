package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.MfgMaster;

public interface MfgService {

    // Create Manufacturer
    MfgMaster saveManufacturer(MfgMaster manufacturer);

    // Get All Manufacturers
    List<MfgMaster> getAllManufacturers();

    // Get Manufacturer By Id
    MfgMaster getManufacturerById(Integer id);

    // Get Manufacturers By Segment
    List<MfgMaster> getManufacturersBySegment(Integer segmentId);

    // Update Manufacturer
    MfgMaster updateManufacturer(MfgMaster manufacturer);

    // Delete Manufacturer
    void deleteManufacturer(Integer id);
}