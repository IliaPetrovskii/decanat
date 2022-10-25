package com.petrovskii.decanat.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lecturers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlect", nullable = false)
    private Integer id;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "patronymic", length = 15)
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "adr", length = 80)
    private String adr;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "department", nullable = false, length = 40)
    private String department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lecturer lecturer = (Lecturer) o;
        return id != null && Objects.equals(id, lecturer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}