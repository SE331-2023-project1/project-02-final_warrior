package se331.proj.rest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.proj.rest.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findAll();
    Page<Student> findByNameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String name, String surname, Pageable page);
}