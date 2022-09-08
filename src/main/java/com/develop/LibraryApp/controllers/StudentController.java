package com.develop.LibraryApp.controllers;

import com.develop.LibraryApp.models.Student;
import com.develop.LibraryApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String fetchStudents(Model model) {
        List<Student> listStudents = studentService.fetchStudents();
        model.addAttribute("listStudents", listStudents);
        return "students";
    }

    @PostMapping("/add")
    public String addNewStudent(Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteStudentById(Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public Optional<Student> findStudentById(Long id) {
        return studentService.fetchStudentById(id);
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editStudent(Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students";
    }
}

