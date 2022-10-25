package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
}