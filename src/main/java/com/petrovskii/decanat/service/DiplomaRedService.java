package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DiplomaRed;

public interface DiplomaRedService {
    Iterable<DiplomaRed> findAllByAvgBallGreaterThanEqual(Double avgBall);
}
