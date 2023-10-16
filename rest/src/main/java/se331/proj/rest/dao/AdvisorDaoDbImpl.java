package se331.proj.rest.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Advisor;
import se331.proj.rest.repository.AdvisorRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AdvisorDaoDbImpl implements AdvisorDao{
    final AdvisorRepository advisorRepository;

    @Override
    public Integer getAdvisorSize(){
        return Math.toIntExact(advisorRepository.count());
    }

    @Override
    public List<Advisor> getAdvisors(Integer perPage, Integer page) {
        List<Advisor> advisors = advisorRepository.findAll();
        perPage = perPage == null?advisors.size():perPage;
        page = page == null?1:page;
        int firstIndex = (page - 1) * perPage;
        List<Advisor> output = advisors.subList(firstIndex, firstIndex+perPage);
        return output;
    }

    @Override
    public Advisor getAdvisor(Integer id) {
        return advisorRepository.findById(id).orElse(null);
    }
}
