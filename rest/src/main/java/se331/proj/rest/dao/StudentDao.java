package se331.proj.rest.dao;

import org.springframework.data.domain.Page;

import se331.proj.rest.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer perPage, Integer page);
    Student getStudent(Integer studentId);
    Student save(Student student);
}
