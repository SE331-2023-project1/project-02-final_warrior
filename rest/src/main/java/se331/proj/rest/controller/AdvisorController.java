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

import se331.proj.rest.entity.Advisor;
import se331.proj.rest.service.AdvisorService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdvisorController {
    final AdvisorService advisorService;

    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page) {
            Page<Advisor> pageOutput = advisorService.getAdvisors(perPage, page);

            HttpHeaders responseHeader = new HttpHeaders();

            responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
            return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);
    }

    
    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id") Integer id) {
        Advisor output = advisorService.getAdvisor(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/advisors")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor) {
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(output);
    }
}