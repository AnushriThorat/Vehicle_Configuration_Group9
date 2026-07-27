package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.repository.InvoiceDetailRepository;
import com.vehiclecfg.services.InvoiceDetailServices;

public class InvoiceDetailsServicesImpl implements InvoiceDetailServices{

	@Autowired
	private InvoiceDetailRepository repo;
	
	public InvoiceDetail save(InvoiceDetail obj) {
		return repo.save(obj);
	}
	
	public List<InvoiceDetail> getAll(){
		return repo.findAll();
	}
}
