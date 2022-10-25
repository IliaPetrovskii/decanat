package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DebtSubject;

public interface DebtSubjectService {
    Iterable<DebtSubject> findAllByDiscipline(String discipline);
}
