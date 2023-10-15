package se331.proj.rest.controller;

import org.springframework.stereotype.Controller;
import se331.proj.rest.entity.Student;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
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
}