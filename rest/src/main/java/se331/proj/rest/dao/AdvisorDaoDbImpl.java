package se331.proj.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Advisor> getAdvisors(Integer perPage, Integer page) {
        return advisorRepository.findAll(PageRequest.of(page - 1, perPage));
    }

//    @Override
//    public Advisor getAdvisor(Long id) {
//        return advisorRepository.findById(id).orElse(null);
//    }
@Override
public Advisor getAdvisor(Long id) {
    return advisorRepository.findById(id).orElse(null);
}

    @Override
    public Advisor save(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

}
