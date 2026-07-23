package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Vehicle_Detail;

public interface Vehicle_Details {
	
	List<Vehicle_Detail> findConfigurableComponentsByModel(Integer model_id);

}
