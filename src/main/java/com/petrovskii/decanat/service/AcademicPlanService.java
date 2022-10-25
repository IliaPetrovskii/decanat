package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.AcademicPlan;

public interface AcademicPlanService {
    Iterable<AcademicPlan> findAll();
}
