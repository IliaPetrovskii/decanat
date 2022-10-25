package com.petrovskii.decanat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "session")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "ball", nullable = false)
    private String ball;

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
        Session session = (Session) o;
        return id != null && Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}