package se331.proj.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
        .imageLink("https://i.redd.it/qjfd7hi1w8ub1.jpg")
        .build());
    }

    @Override
    public Integer getAdvisorSize() {
        return advisorList.size();
    }

    @Override
    public Page<Advisor> getAdvisors(Integer perPage, Integer page) {
        perPage = perPage == null?advisorList.size():perPage;
        page = page == null?1:page;
        int firstIndex = (page - 1) * perPage;
        return new PageImpl<>(advisorList.subList(firstIndex, firstIndex+perPage), PageRequest.of(page, perPage), advisorList.size());
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

    @Override
    public Advisor save(Advisor advisor) {
        advisor.setId(advisorList.get(advisorList.size()-1).getId()+1);
        advisorList.add(advisor);
        return advisor;
    }
    
}
