package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.Student;

public interface StudentService {

    Iterable<Student> findAll();
    Iterable<Student> findStudentsByGroupAndFIO(String surname, String name, String patronymic, String group);
    Iterable<Student> findAllBySmstr(String semester);
    void updateStipend();
    void stipendSetZero();
}
