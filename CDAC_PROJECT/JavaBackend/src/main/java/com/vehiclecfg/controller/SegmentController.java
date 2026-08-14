package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Segment;
import com.vehiclecfg.services.SegmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class SegmentController {

    @Autowired
    private SegmentService service;

    // ==================== GET ALL ====================

    @GetMapping("/getSegment")
    public ResponseEntity<List<Segment>> getAll() {

        return ResponseEntity.ok(
                service.GetAll()
        );

    }

    // ==================== CREATE ====================

    @PostMapping("/saveSegment")
    public ResponseEntity<Segment> saveSegment(
            @RequestBody Segment segment) {

        Segment savedSegment =
                service.AddSegment(segment);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedSegment);

    }

    // ==================== UPDATE ====================

    @PutMapping("/update/{id}")
    public ResponseEntity<Segment> updateSegment(
            @PathVariable int id,
            @RequestBody Segment segment) {

        Segment updatedSegment =
                service.UpdateSegment(id, segment);

        return ResponseEntity.ok(updatedSegment);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSegment(
            @PathVariable int id) {

        service.DeleteSegment(id);

        return ResponseEntity.noContent().build();

    }

}