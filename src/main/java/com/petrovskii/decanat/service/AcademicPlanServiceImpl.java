package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.AcademicPlan;
import com.petrovskii.decanat.repository.AcademicPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AcademicPlanServiceImpl implements AcademicPlanService{

    private final AcademicPlanRepository academicPlanRepository;

    @Override
    public Iterable<AcademicPlan> findAll() {
        return academicPlanRepository.findAll();
    }
}
