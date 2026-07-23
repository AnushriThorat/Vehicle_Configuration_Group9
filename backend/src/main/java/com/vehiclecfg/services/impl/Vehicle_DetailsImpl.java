package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Vehicle_Detail;
import com.vehiclecfg.repository.Vehicle_DetailRepository;
import com.vehiclecfg.services.Vehicle_Details;

@Service
public class Vehicle_DetailsImpl implements Vehicle_Details{

	@Autowired
	private Vehicle_DetailRepository vehicledetailrepo;
	
	@Override
	public List<Vehicle_Detail> findConfigurableComponentsByModel(Integer model_id) {
		
		return vehicledetailrepo.findConfigurableComponentsByModel(model_id);
		
	}

}
