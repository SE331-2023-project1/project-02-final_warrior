package se331.proj.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page) {
            perPage = perPage == null?studentList.size():perPage;
            page = page == null?1:page;
            Integer firstIndex = (page-1) * perPage;
            List<Student> output = new ArrayList<>();
            for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(studentList.get(i));
            }
            return ResponseEntity.ok(output);
        }
}