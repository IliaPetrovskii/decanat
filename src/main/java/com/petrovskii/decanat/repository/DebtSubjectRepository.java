package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.DebtSubject;
import com.petrovskii.decanat.entity.SheetExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtSubjectRepository extends JpaRepository<DebtSubject, Long> {
    Iterable<DebtSubject> findAllByDiscipline(String discipline);
}