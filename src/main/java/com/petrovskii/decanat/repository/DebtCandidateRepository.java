package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.DebtCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtCandidateRepository extends JpaRepository<DebtCandidate, Integer> {
}