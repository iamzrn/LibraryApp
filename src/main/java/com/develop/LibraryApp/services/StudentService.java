package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addNewStudent(Student student);

    List<Student> fetchStudents();

    Optional<Student> fetchStudentById(Long studentId);

    void deleteStudentById(Long studentId);
}
