package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Segment;

public interface SegmentService {
	
	List<Segment> GetAll();
	Segment AddSegment(Segment s);
	Segment UpdateSegment(int id, Segment update);
	String DeleteSegment(int id);
}
