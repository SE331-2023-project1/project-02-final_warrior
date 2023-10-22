package se331.proj.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Student;
import se331.proj.rest.service.StudentService;
import se331.proj.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    
    @GetMapping("students")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page,
        @RequestParam(value = "_name", required = false) String name) {
            perPage = perPage == null?3:perPage;
            page = page == null?1:page;
            Page<Student> pageOutput;
            if (name == null) {
                pageOutput = studentService.getStudents(perPage, page);
            } else {
                pageOutput = studentService.getStudents(name, PageRequest.of(page-1, perPage));
            }

            HttpHeaders responseHeader = new HttpHeaders();

            responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
            return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Student output = studentService.getStudent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student output = studentService.save(student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }
}