package com.vehiclecfg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Segment;
@Service
public interface SegmentService {
	
	List<Segment> GetAll();
	Segment AddSegment(Segment s);
	Segment UpdateSegment(int id, Segment update);
	String DeleteSegment(int id);
}
