package com.petrovskii.decanat.entity;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "sheet_pass")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SheetPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nsb", nullable = false)
    private Integer nsb;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "patronymic", length = 15)
    private String patronymic;

    @Column(name = "`group`", nullable = false, length = 7)
    private String group;

    @Column(name = "dispiline", nullable = false, length = 40)
    private String dispiline;

    @Column(name = "pass", nullable = false)
    private Boolean pass = false;
}