package se331.proj.rest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import se331.proj.rest.entity.Advisor;

@Repository
@Profile("manual")
public class AdvisorDaoImpl implements AdvisorDao{
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

    @Override
    public Integer getAdvisorSize() {
        return advisorList.size();
    }

    @Override
    public List<Advisor> getAdvisors(Integer perPage, Integer page) {
        perPage = perPage == null?advisorList.size():perPage;
        page = page == null?1:page;
        int firstIndex = (page - 1) * perPage;
        return advisorList.subList(firstIndex, firstIndex+perPage);
    }

    @Override
    public Advisor getAdvisor(Integer id) {
        return advisorList
            .stream()
            .filter(advisor ->
                advisor
                .getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
