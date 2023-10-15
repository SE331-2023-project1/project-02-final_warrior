package se331.proj.rest.dao;

import java.util.List;

import se331.proj.rest.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    List<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Integer id);
}
