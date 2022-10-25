package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.SheetExam;

public interface SheetExamService {
    Iterable<SheetExam> findAllByGroup(String group);
}
