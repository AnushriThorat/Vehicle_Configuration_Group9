package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.MfgMaster;

public interface MfgService {

    MfgMaster saveManufacturer(MfgMaster manufacturer);

    List<MfgMaster> getAllManufacturers();

    MfgMaster getManufacturerById(Integer id);

    MfgMaster updateManufacturer(MfgMaster manufacturer);

    void deleteManufacturer(Integer id);
}