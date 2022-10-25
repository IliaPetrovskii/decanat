package com.petrovskii.decanat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "academic_plan")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AcademicPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddispln", nullable = false)
    private Integer id;

    @Column(name = "displn", nullable = false, length = 40)
    private String displn;

    @Lob
    @Column(name = "smstr", nullable = false)
    private String smstr;

    @Column(name = "type_passing", nullable = false)
    private Boolean typePassing = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturers_idlect")
    @ToString.Exclude
    private Lecturer lecturerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups_idgrp")
    @ToString.Exclude
    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AcademicPlan that = (AcademicPlan) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}