package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DebtSubject;
import com.petrovskii.decanat.repository.DebtSubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DebtSubjectServiceImpl implements DebtSubjectService {

    private final DebtSubjectRepository debtSubjectRepository;

    @Override
    public Iterable<DebtSubject> findAllByDiscipline(String discipline){
       return debtSubjectRepository.findAllByDiscipline(discipline);
    }
}
