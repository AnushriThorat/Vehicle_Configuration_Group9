package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.dto.VehicleDetailsResponseDto;
import com.vehiclecfg.entities.VehicleDetail;

public interface VehicleDetailService {

    VehicleDetail save(VehicleDetail vehicleDetail);

    List<VehicleDetail> getAll();

    VehicleDetail getById(Integer id);

    VehicleDetail update(Integer id, VehicleDetail vehicleDetail);

    void delete(Integer id);

    List<VehicleDetail> getVehicleDetailsByModel(Integer modelId);

    VehicleDetailsResponseDto getVehicleDetailsResponse(Integer modelId);
}