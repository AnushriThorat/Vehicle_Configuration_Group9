package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.MfgMaster;
import com.vehiclecfg.exception.ManufacturerNotFoundException;
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

        return mfgRepository.findById(id)

                .orElseThrow(() ->

                        new ManufacturerNotFoundException(

                                "Manufacturer not found with ID : " + id

                        )

                );

    }

    @Override
    public List<MfgMaster> getManufacturersBySegment(Integer segmentId) {

        return mfgRepository.findBySegmentSegId(segmentId);

    }

    @Override
    public MfgMaster updateManufacturer(MfgMaster manufacturer) {

        Integer id = manufacturer.getMfgId();

        mfgRepository.findById(id)

                .orElseThrow(() ->

                        new ManufacturerNotFoundException(

                                "Manufacturer not found with ID : " + id

                        )

                );

        return mfgRepository.save(manufacturer);

    }

    @Override
    public void deleteManufacturer(Integer id) {

        MfgMaster existing = mfgRepository.findById(id)

                .orElseThrow(() ->

                        new ManufacturerNotFoundException(

                                "Manufacturer not found with ID : " + id

                        )

                );

        mfgRepository.delete(existing);

    }

}