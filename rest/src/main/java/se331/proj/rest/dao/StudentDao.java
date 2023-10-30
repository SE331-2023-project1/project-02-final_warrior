package se331.proj.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.proj.rest.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer perPage, Integer page);
    Page<Student> getStudents(String name, Pageable page);
    Student getStudent(Long studentId);
    Student save(Student student);
}
