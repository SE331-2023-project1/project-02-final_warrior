package se331.proj.rest.service;

import org.springframework.data.domain.Page;

import se331.proj.rest.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Integer id);
    Student save(Student student);
}