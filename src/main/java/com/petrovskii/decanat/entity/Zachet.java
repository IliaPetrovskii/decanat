package com.petrovskii.decanat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "zachet")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Zachet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "pass", nullable = false)
    private Boolean pass;

    @Lob
    @Column(name = "smstr", nullable = false)
    private String smstr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_nsb")
    @ToString.Exclude
    private Student nsb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_plan_iddispln")
    @ToString.Exclude
    private AcademicPlan displnID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_plan_lecturers_idlect")
    @ToString.Exclude
    private AcademicPlan lecturerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_plan_groups_idgrp")
    @ToString.Exclude
    private AcademicPlan group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Zachet zachet = (Zachet) o;
        return id != null && Objects.equals(id, zachet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}