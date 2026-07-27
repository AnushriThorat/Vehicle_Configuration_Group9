package com.vehiclecfg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.repository.InvoiceDetailRepository;





public interface InvoiceDetailServices {
	
	public InvoiceDetail save(InvoiceDetail obj) ;

	
	public List<InvoiceDetail> getAll();
}
