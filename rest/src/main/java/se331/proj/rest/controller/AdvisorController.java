package se331.proj.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se331.proj.rest.entity.Advisor;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdvisorController {
    List<Advisor> advisorList;

    @PostConstruct
    public void init() {
        advisorList = new ArrayList<>();
        advisorList.add(Advisor.builder()
        .id(1234)
        .name("John")
        .surname("Doe")
        .dept("CAMT")
        .position("Lecturer")
        .studentId(new ArrayList<Integer>(Arrays.asList(642115024)))
        .imageLink("https://i.redd.it/qjfd7hi1w8ub1.jpg")
        .build());
    }

    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page) {
            perPage = perPage == null?advisorList.size():perPage;
            page = page == null?1:page;
            Integer firstIndex = (page-1) * perPage;
            List<Advisor> output = new ArrayList<>();
            for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(advisorList.get(i));
            }
            return ResponseEntity.ok(output);
        }
}