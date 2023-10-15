package se331.proj.rest.service;

import java.util.List;

import se331.proj.rest.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    List<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Integer id);
}