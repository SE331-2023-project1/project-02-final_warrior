package se331.proj.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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

            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("x-total-count", String.valueOf(studentList.size()));

            try {
                for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(studentList.get(i));
                }
                return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
            } catch (IndexOutOfBoundsException ex) {
                return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
            }
    
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Student output = null;
        for ( Student student : studentList ) {
            if (student.getId().equals(id)) {
                output = student;
                break;
            }
        }
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}