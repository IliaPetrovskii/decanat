package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DiplomaInsert;
import com.petrovskii.decanat.repository.DiplomaInsertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiplomaInsertServiceImpl implements DiplomaInsertService{

    private final DiplomaInsertRepository diplomaInsertRepository;

    @Override
    public Iterable<DiplomaInsert> findAllByNsb(Integer nsb){
        return diplomaInsertRepository.findAllByNsb(nsb);
    }
}
