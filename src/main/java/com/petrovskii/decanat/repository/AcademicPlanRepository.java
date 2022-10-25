package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.AcademicPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicPlanRepository extends JpaRepository<AcademicPlan, Integer> {
}