package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DebtCandidate;
import com.petrovskii.decanat.repository.DebtCandidateRepository;
import com.petrovskii.decanat.repository.DebtSubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DebtCandidateServiceImpl implements DebtCandidateService{

    private final DebtCandidateRepository debtCandidateRepository;

    @Override
    public Iterable<DebtCandidate> findAll(){
        return debtCandidateRepository.findAll();
    }
}
