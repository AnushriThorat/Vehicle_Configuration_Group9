package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Segment;
import com.vehiclecfg.repository.SegmentRepository;
import com.vehiclecfg.services.SegmentService;

@Service
public class SegmentServiceImp implements SegmentService{

	@Autowired
	SegmentRepository repository;
	
	public List<Segment> GetAll(){
		return repository.findAll();
	}
	
	public Segment AddSegment(Segment s) {
		return repository.save(s);
	}
	
	public Segment UpdateSegment(int id, Segment updateSeg) {
		
		Segment existingSeg = repository.findById(id).orElse(null);
		
		if(existingSeg != null) {
			
			existingSeg.setSegmentName(updateSeg.getSegmentName());
			existingSeg.setMinQty(updateSeg.getMinQty());
			
			return repository.save(existingSeg);
		}
		return null;
	}
	
	public String DeleteSegment(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return "Segment deleted successfully";
		}
		
		return "Segment not found";
	}
}
