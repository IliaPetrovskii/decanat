package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.SheetExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetExamRepository extends JpaRepository<SheetExam, Integer> {

    Iterable<SheetExam> findAllByGroup(String group);
}