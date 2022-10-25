package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.SheetExam;
import com.petrovskii.decanat.repository.SheetExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SheetExamServiceImpl implements SheetExamService{

    private final SheetExamRepository sheetExamRepository;

    @Override
    public Iterable<SheetExam> findAllByGroup(String group) {
        return sheetExamRepository.findAllByGroup(group);
    }
}
