package com.petrovskii.decanat.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nsb", updatable = false, nullable = false, unique=true)
    private Integer nsb;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "patronymic", length = 15)
    private String patronymic;

    @Lob
    @Column(name = "smstr", nullable = false)
    private String smstr;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "adr", length = 80)
    private String adr;

    @Column(name = "stip")
    private Integer stip;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "adm_conditions", length = 45)
    private String admConditions;

    @Column(name = "parents_comm", length = 45)
    private String parentsComm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups_idgrp")
    @ToString.Exclude
    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return nsb != null && Objects.equals(nsb, student.nsb);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
