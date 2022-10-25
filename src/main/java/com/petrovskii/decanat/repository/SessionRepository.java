package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}