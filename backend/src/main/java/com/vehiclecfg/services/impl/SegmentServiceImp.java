package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Segment;
import com.vehiclecfg.exception.SegmentNotFoundException;
import com.vehiclecfg.repository.SegmentRepository;
import com.vehiclecfg.services.SegmentService;

@Service
public class SegmentServiceImp implements SegmentService {

    @Autowired
    private SegmentRepository repository;

    @Override
    public List<Segment> GetAll() {

        return repository.findAll();

    }

    @Override
    public Segment AddSegment(Segment segment) {

        return repository.save(segment);

    }

    @Override
    public Segment getById(int id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new SegmentNotFoundException(

                                "Segment not found with ID : " + id

                        )

                );

    }

    @Override
    public Segment UpdateSegment(int id, Segment updateSeg) {

        Segment existingSeg = repository.findById(id)

                .orElseThrow(() ->

                        new SegmentNotFoundException(

                                "Segment not found with ID : " + id

                        )

                );

        existingSeg.setSegName(updateSeg.getSegName());

        existingSeg.setMinQty(updateSeg.getMinQty());

        return repository.save(existingSeg);

    }

    @Override
    public String DeleteSegment(int id) {

        Segment existingSeg = repository.findById(id)

                .orElseThrow(() ->

                        new SegmentNotFoundException(

                                "Segment not found with ID : " + id

                        )

                );

        repository.delete(existingSeg);

        return "Segment deleted successfully";

    }

}