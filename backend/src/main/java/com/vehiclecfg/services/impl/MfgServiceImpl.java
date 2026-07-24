package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.MfgMaster;
import com.vehiclecfg.repository.MfgRepository;
import com.vehiclecfg.services.MfgService;

@Service
public class MfgServiceImpl implements MfgService {

    @Autowired
    private MfgRepository mfgRepository;

    @Override
    public MfgMaster saveManufacturer(MfgMaster manufacturer) {
        return mfgRepository.save(manufacturer);
    }

    @Override
    public List<MfgMaster> getAllManufacturers() {
        return mfgRepository.findAll();
    }

    @Override
    public MfgMaster getManufacturerById(Integer id) {
        return mfgRepository.findById(id).orElse(null);
    }

    @Override
    public MfgMaster updateManufacturer(MfgMaster manufacturer) {
        return mfgRepository.save(manufacturer);
    }

    @Override
    public void deleteManufacturer(Integer id) {
        mfgRepository.deleteById(id);
    }
}