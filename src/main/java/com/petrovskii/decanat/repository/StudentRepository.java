package com.petrovskii.decanat.repository;

import com.petrovskii.decanat.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select st from Student st where st.surname LIKE CONCAT('%',:surname,'%') and st.name like CONCAT('%',:name,'%') " +
            "and (st.patronymic like CONCAT('%',:patronymic,'%') or st.patronymic is null) and st.group.id like CONCAT('%',:group,'%')")
    Iterable<Student> findStudentsByGroupAndFIO(@Param("surname") String surname, @Param("name") String name,
                                                @Param("patronymic") String patronymic, @Param("group") String group);

    Iterable<Student> findAllBySmstr(String semester);

    @Modifying
    @Transactional
    @Query(value = "Update students, (select koefs.nsb, semester_koef, ball_koef\n" +
            "                                      from (SELECT students.nsb,\n" +
            "                                                   students.surname,\n" +
            "                                                   students.name,\n" +
            "                                                   students.patronymic,\n" +
            "                                                   students.groups_idgrp,\n" +
            "                                                   students.smstr,\n" +
            "                                                   avg(ball + 1)        as avg_ball,\n" +
            "                                                   students.smstr DIV 2 as semester_koef,\n" +
            "                                                   CASE\n" +
            "                                                       when avg(ball + 1) = 5 THEN 3\n" +
            "                                                       when avg(ball + 1) = 4 THEN 1\n" +
            "                                                       when avg(ball + 1) < 5 and avg(ball + 1) > 4 THEN 2\n" +
            "                                                       END              AS ball_koef\n" +
            "                                            FROM students\n" +
            "                                                     INNER JOIN session on students.nsb = session.students_nsb\n" +
            "                                                     INNER JOIN academic_plan\n" +
            "                                                                on session.academic_plan_iddispln =\n" +
            "                                                                   academic_plan.iddispln and\n" +
            "                                                                   session.academic_plan_lecturers_idlect =\n" +
            "                                                                   academic_plan.lecturers_idlect and\n" +
            "                                                                   session.academic_plan_groups_idgrp =\n" +
            "                                                                   academic_plan.groups_idgrp\n" +
            "                                            WHERE students.smstr = session.smstr\n" +
            "                                            group by nsb\n" +
            "                                            order by avg_ball) koefs\n" +
            "                                               inner join stipend_candidates on stipend_candidates.nsb = koefs.nsb) candidates\n" +
            "Set students.stip = (3000 + 500 * candidates.ball_koef + 200 * candidates.semester_koef)\n" +
            "where students.nsb = candidates.nsb;", nativeQuery = true)
    void updateStipend();

    @Modifying
    @Transactional
    @Query(value = "UPDATE students set students.stip = 0", nativeQuery = true)
    void stipendSetZero();
}