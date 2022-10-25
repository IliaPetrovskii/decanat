package com.petrovskii.decanat.controller;

import com.petrovskii.decanat.entity.*;
import com.petrovskii.decanat.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {

    private final StudentServiceImpl studentService;
    private final SheetPassServiceImpl sheetPassService;
    private final SheetExamServiceImpl sheetExamService;
    private final DebtSubjectServiceImpl debtSubjectService;
    private final AcademicPlanServiceImpl academicPlanService;
    private final DebtCandidateServiceImpl debtCandidateService;
    private final StipendCandidateServiceImpl stipendCandidateService;
    private final DiplomaInsertServiceImpl diplomaInsertService;
    private final DiplomaRedServiceImpl diplomaRedService;

    @GetMapping(path = "/")
    public String allStudents(Model model) {
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(path = "/search")
    public String searchStudents(@RequestParam(value = "surname") String surname,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "patronymic") String patronymic,
                                 @RequestParam(value = "group") String group,
                                 Model model) {
        Iterable<Student> students = studentService.findStudentsByGroupAndFIO(surname, name, patronymic, group);
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(path = "/sheetPass")
    public String sheetPass(@RequestParam(value = "group", defaultValue = "ИВТ11") String group, Model model) {
        Iterable<SheetPass> sheets = sheetPassService.findAllByGroup(group);
        model.addAttribute("sheets", sheets);
        return "sheetPass";
    }

    @GetMapping(path = "/sheetExam")
    public String sheetExam(@RequestParam(value = "group", defaultValue = "ИВТ11") String group, Model model) {
        Iterable<SheetExam> sheets = sheetExamService.findAllByGroup(group);
        model.addAttribute("sheets", sheets);
        return "sheetExam";
    }

    @GetMapping(path = "/debtSubjects")
    public String debtSubjects(@RequestParam(value = "subject", defaultValue = "Введение в Java") String subject, Model model) {
        Iterable<DebtSubject> debtors = debtSubjectService.findAllByDiscipline(subject);
        Iterable<AcademicPlan> subjects = academicPlanService.findAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("debtors", debtors);
        return "debtSubject";
    }

    @GetMapping(path = "/debtCandidates")
    public String debtCandidates(Model model) {
        Iterable<DebtCandidate> debtors = debtCandidateService.findAll();
        model.addAttribute("debtors", debtors);
        return "debtCandidates";
    }

    @GetMapping(path = "/stipendCandidate")
    public String stipendCandidate(Model model) {
        Iterable<StipendCandidate> candidates = stipendCandidateService.findAll();
        model.addAttribute("candidates", candidates);
        return "stipendCandidate";
    }

    @GetMapping(path = "/diplomaInsert")
    public String diplomaInsert(@RequestParam(value = "nsb", defaultValue = "1013") String nsb, Model model) {
        Iterable<Student> students = studentService.findAllBySmstr("8");
        Iterable<DiplomaInsert> inserts = diplomaInsertService.findAllByNsb(Integer.parseInt(nsb));
        model.addAttribute("inserts", inserts);
        model.addAttribute("students", students);
        return "diplomaInsert";
    }

    @GetMapping(path = "/diplomaRed")
    public String diplomaRed(Model model) {
        Iterable<DiplomaRed> candidates = diplomaRedService.findAllByAvgBallGreaterThanEqual(4.75);
        model.addAttribute("candidates", candidates);
        return "diplomaRed";
    }

    @GetMapping(path = "/stipendDistribute")
    public String stipendDistribute() {
        studentService.stipendSetZero();
        studentService.updateStipend();
        return "redirect:/";
    }
}
