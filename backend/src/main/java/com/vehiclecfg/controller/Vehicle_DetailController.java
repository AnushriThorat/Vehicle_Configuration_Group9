package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclecfg.dto.vehicle_detaildto;
import com.vehiclecfg.entities.Vehicle_Detail;
import com.vehiclecfg.services.Vehicle_Details;
import com.vehiclecfg.services.impl.Vehicle_DetailsImpl;

@RestController
@RequestMapping("api/vehicle_details")
public class Vehicle_DetailController {
	
	@Autowired
	private Vehicle_Details vehicledetailsserices;
	
	
	@PostMapping("/configurable")
	public List<Vehicle_Detail> getConfigurableComponents(@RequestBody vehicle_detaildto vehicledetaildto){
		return vehicledetailsserices.findConfigurableComponentsByModel(vehicledetaildto.getModel_id());
	
	}

}
