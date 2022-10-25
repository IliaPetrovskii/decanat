package com.petrovskii.decanat.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "diploma_red")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DiplomaRed {
    @Id
    @Column(name = "nsb", nullable = false)
    private Integer nsb;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "patronymic", length = 15)
    private String patronymic;

    @Column(name = "groups_idgrp", nullable = false, length = 7)
    private String group;

    @Column(name = "avg_ball")
    private Double avgBall;
}