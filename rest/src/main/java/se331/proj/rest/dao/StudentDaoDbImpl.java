package se331.proj.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Student;
import se331.proj.rest.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDbImpl implements StudentDao{
    final StudentRepository studentRepository;

    @Override
    public Integer getStudentSize(){
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getStudents(Integer perPage, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, perPage));
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(String name, Pageable page) {
        return studentRepository.findByNameContaining(name, page);
    }
}