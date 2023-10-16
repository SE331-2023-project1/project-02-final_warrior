package se331.proj.rest.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
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
    public List<Student> getStudents(Integer perPage, Integer page) {
        List<Student> students = studentRepository.findAll();
        perPage = perPage == null?students.size():perPage;
        page = page == null?1:page;
        int firstIndex = (page - 1) * perPage;
        List<Student> output = students.subList(firstIndex, firstIndex+perPage);
        return output;
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
