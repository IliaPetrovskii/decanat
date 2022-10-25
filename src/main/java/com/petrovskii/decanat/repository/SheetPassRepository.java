package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.SheetPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SheetPassRepository extends JpaRepository<SheetPass, Integer> {
    Iterable<SheetPass> findAllByGroup(String group);
}