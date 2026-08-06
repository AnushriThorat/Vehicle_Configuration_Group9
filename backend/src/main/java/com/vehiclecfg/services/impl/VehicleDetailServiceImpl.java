package com.vehiclecfg.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.dto.ComponentDto;
import com.vehiclecfg.dto.VehicleDetailsResponseDto;
import com.vehiclecfg.entities.VehicleDetail;
import com.vehiclecfg.exception.InvoiceDetailNotFoundException;
import com.vehiclecfg.repository.VehicleDetailRepository;
import com.vehiclecfg.services.VehicleDetailService;

@Service
public class VehicleDetailServiceImpl implements VehicleDetailService {

    @Autowired
    private VehicleDetailRepository repository;

    @Override
    public VehicleDetail save(VehicleDetail vehicleDetail) {

        return repository.save(vehicleDetail);

    }

    @Override
    public List<VehicleDetail> getAll() {

        return repository.findAll();

    }

    @Override
    public VehicleDetail getById(Integer id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Vehicle Detail not found with ID : " + id

                        )

                );

    }

    @Override
    public VehicleDetail update(Integer id, VehicleDetail vehicleDetail) {

        VehicleDetail existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Vehicle Detail not found with ID : " + id

                        )

                );

        existing.setModel(vehicleDetail.getModel());

        existing.setComponent(vehicleDetail.getComponent());

        existing.setCompType(vehicleDetail.getCompType());

        existing.setConfigurable(vehicleDetail.isConfigurable());

        return repository.save(existing);

    }

    @Override
    public void delete(Integer id) {

        VehicleDetail existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Vehicle Detail not found with ID : " + id

                        )

                );

        repository.delete(existing);

    }

    @Override
    public List<VehicleDetail> getVehicleDetailsByModel(Integer modelId) {

        return repository.findByModelModelId(modelId);

    }

    @Override
    public VehicleDetailsResponseDto getVehicleDetailsResponse(Integer modelId) {

        List<VehicleDetail> vehicleDetails =
                repository.findByModelModelId(modelId);

        if (vehicleDetails.isEmpty()) {

            throw new InvoiceDetailNotFoundException(

                    "No Vehicle Details found for Model ID : " + modelId

            );

        }

        VehicleDetailsResponseDto response =
                new VehicleDetailsResponseDto();

        VehicleDetail first = vehicleDetails.get(0);

        response.setModelId(first.getModel().getModelId());

        response.setModelName(first.getModel().getModelName());

        response.setImagePath(first.getModel().getImagePath());

        response.setBasePrice(first.getModel().getBasePrice());

        response.setMfgId(first.getModel().getMfgmaster().getMfgId());

        response.setMfgName(first.getModel().getMfgmaster().getMfgName());

        response.setSegId(first.getModel().getSegment().getSegId());

        response.setSegName(first.getModel().getSegment().getSegName());

        List<ComponentDto> core = new ArrayList<>();

        List<ComponentDto> interior = new ArrayList<>();

        List<ComponentDto> exterior = new ArrayList<>();

        List<ComponentDto> standard = new ArrayList<>();

        for (VehicleDetail detail : vehicleDetails) {

            ComponentDto dto = new ComponentDto();

            dto.setCompId(detail.getComponent().getCompId());

            dto.setCompName(detail.getComponent().getCompName());

            dto.setCompType(detail.getCompType().name());

            dto.setConfigurable(detail.isConfigurable());

            switch (detail.getCompType()) {

                case C:
                    core.add(dto);
                    break;

                case I:
                    interior.add(dto);
                    break;

                case E:
                    exterior.add(dto);
                    break;

                case S:
                    standard.add(dto);
                    break;

            }

        }

        response.setCoreComponents(core);

        response.setInteriorComponents(interior);

        response.setExteriorComponents(exterior);

        response.setStandardComponents(standard);

        return response;

    }

}