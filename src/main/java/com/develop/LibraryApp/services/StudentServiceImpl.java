package com.develop.LibraryApp.services;

import com.develop.LibraryApp.models.Student;
import com.develop.LibraryApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> fetchStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

