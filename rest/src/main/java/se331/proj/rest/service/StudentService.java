package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.proj.rest.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String name, Pageable page);
    Student getStudent(Long id);

    Student updateDetail(Student student);
    Student save(Student student);
}