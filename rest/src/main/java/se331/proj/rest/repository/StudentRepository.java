package se331.proj.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se331.proj.rest.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>{
    List<Student> findAll();
}