package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.Zachet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZachetRepository extends JpaRepository<Zachet, Integer> {
}