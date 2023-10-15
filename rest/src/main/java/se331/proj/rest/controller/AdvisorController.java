package se331.proj.rest.controller;

import org.springframework.stereotype.Controller;
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

    
}