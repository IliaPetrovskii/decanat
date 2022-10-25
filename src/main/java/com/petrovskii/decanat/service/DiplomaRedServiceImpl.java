package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DiplomaRed;
import com.petrovskii.decanat.repository.DiplomaRedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiplomaRedServiceImpl implements DiplomaRedService{

    private final DiplomaRedRepository diplomaRedRepository;

    @Override
    public Iterable<DiplomaRed> findAllByAvgBallGreaterThanEqual(Double avgBall) {
        return diplomaRedRepository.findAllByAvgBallGreaterThanEqual(avgBall);
    }
}
