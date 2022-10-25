package com.petrovskii.decanat.service;

import com.petrovskii.decanat.entity.DiplomaInsert;

public interface DiplomaInsertService {

    Iterable<DiplomaInsert> findAllByNsb(Integer nsb);
}
