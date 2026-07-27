package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclecfg.entities.MfgMaster;
import com.vehiclecfg.services.MfgService;

@RestController
@RequestMapping("/manufacturers")
public class MfgController {
	@Autowired
	private MfgService mfgService;
	
	@PostMapping
	public MfgMaster saveManufacturer(@RequestBody MfgMaster manufacturer) {
		return mfgService.saveManufacturer(manufacturer);
	}
	@GetMapping
	public List<MfgMaster> getAllManufacturers(){
		return mfgService.getAllManufacturers();
	}
	@GetMapping("/{id}")
	public MfgMaster getMnufacturerById(@PathVariable Integer id) {
		return mfgService.getManufacturerById(id);
	}
	@PutMapping("/{id}")
		public MfgMaster updateManufacturer(@PathVariable Integer id,@RequestBody MfgMaster manufacturer) {
			manufacturer.setMfgId(id);
			return mfgService.updateManufacturer(manufacturer);
		}
	@DeleteMapping("/{id}")
	public String deteleManufacturer(@PathVariable Integer id) {
		mfgService.deleteManufacturer(id);
		return "Manufacturer Deleted Successfully";
		
		}

}
