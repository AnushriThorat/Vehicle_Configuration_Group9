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

import com.vehiclecfg.entities.Segment;
import com.vehiclecfg.services.SegmentService;

@RestController
@RequestMapping("/api")
public class SegmentController {
	
	@Autowired
	SegmentService service;
	
	@GetMapping("/getSegment")
	public List<Segment> GetAll(){
		return service.GetAll();
	}
	
	@PostMapping("/saveSegment")
	public Segment saveSegment(@RequestBody Segment s) {
		return service.AddSegment(s);
	}
	
	@PutMapping("/update/{id}")
	public Segment updateSegment(@PathVariable int id, @RequestBody Segment s) {
		return service.UpdateSegment(id, s);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSegment(@PathVariable int id) {
		return service.DeleteSegment(id);
	}
	
	
}
