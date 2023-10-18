package se331.proj.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import se331.proj.rest.entity.Student;

@Repository
@Profile("manual")
public class StudentDaoImpl implements StudentDao {
    List<Student> studentList;
    
    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(Student.builder()
        .id(642115024)
        .name("Thaipat")
        .surname("Sukhumpraisan")
        .dept("CAMT")
        .advisorId(1234)
        .imageLink("https://i.redd.it/jn8p6oejm0ub1.jpg")
        .build());
    }

    @Override
    public Integer getStudentSize() {
        return studentList.size();
    }

    @Override
    public Page<Student> getStudents(Integer perPage, Integer page) {
        perPage = perPage == null?studentList.size():perPage;
        page = page == null?1:page;
        int firstIndex = (page - 1) * perPage;
        return new PageImpl<>(studentList.subList(firstIndex, firstIndex+perPage), PageRequest.of(page, perPage), studentList.size());
    }

    @Override
    public Student getStudent(Integer id) {
        return studentList
            .stream()
            .filter(student ->
                student
                .getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    @Override
    public Student save(Student student) {
        student.setId(studentList.get(studentList.size()-1).getId()+1);
        studentList.add(student);
        return student;
    }
}
