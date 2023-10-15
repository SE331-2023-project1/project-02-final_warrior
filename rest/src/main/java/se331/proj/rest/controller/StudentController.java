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
        studentList.add(Student.builder().build());
    }
}