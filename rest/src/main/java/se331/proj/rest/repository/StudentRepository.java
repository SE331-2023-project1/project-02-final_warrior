package se331.proj.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.proj.rest.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findAll();
}