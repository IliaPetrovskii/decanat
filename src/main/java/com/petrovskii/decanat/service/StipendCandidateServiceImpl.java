package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.StipendCandidate;
import com.petrovskii.decanat.repository.StipendCandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StipendCandidateServiceImpl implements StipendCandidateService {

    private final StipendCandidateRepository stipendCandidateRepository;

    @Override
    public Iterable<StipendCandidate> findAll() {
        return stipendCandidateRepository.findAll();
    }
}
