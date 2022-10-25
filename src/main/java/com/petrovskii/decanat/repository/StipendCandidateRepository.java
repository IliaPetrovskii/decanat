package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.StipendCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StipendCandidateRepository extends JpaRepository<StipendCandidate, Integer> {

    List<StipendCandidate> findAll();
}