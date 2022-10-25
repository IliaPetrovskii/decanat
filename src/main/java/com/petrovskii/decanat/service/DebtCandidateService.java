package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DebtCandidate;

public interface DebtCandidateService {

    Iterable<DebtCandidate> findAll();
}
