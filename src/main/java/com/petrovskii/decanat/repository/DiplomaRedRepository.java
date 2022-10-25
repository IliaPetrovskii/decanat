package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.DiplomaRed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomaRedRepository extends JpaRepository<DiplomaRed, Integer> {

    Iterable<DiplomaRed> findAllByAvgBallGreaterThanEqual(Double avgBall);
}