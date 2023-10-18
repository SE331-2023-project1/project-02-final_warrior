package se331.proj.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Student;
import se331.proj.rest.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page) {
            Page<Student> pageOutput = studentService.getStudents(perPage, page);

            HttpHeaders responseHeader = new HttpHeaders();

            responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
            return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Student output = studentService.getStudent(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student output = studentService.save(student);
        return ResponseEntity.ok(output);
    }
}