package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.DiplomaInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiplomaInsertRepository extends JpaRepository<DiplomaInsert, Long> {

    Iterable<DiplomaInsert> findAllByNsb(Integer nsb);
}