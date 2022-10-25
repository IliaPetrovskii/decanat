package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.Student;
import com.petrovskii.decanat.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Iterable<Student> findStudentsByGroupAndFIO(String surname, String name, String patronymic, String group) {
        return studentRepository.findStudentsByGroupAndFIO(surname, name, patronymic, group);
    }

    @Override
    public Iterable<Student> findAllBySmstr(String semester) {
        return studentRepository.findAllBySmstr(semester);
    }

    @Override
    public void updateStipend() {
        studentRepository.updateStipend();
    }
    @Override
    public void stipendSetZero() {
        studentRepository.stipendSetZero();
    }
}
