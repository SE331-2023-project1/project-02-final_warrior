package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.AdvisorDao;
import se331.proj.rest.entity.Advisor;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{
    final AdvisorDao advisorDao;
    @Override
    public Integer getAdvisorSize(){
        return advisorDao.getAdvisorSize();
    }

    @Override
    public Page<Advisor> getAdvisors(Integer perPage, Integer page) {
        return advisorDao.getAdvisors(perPage, page);
    }

    @Override
    public Advisor getAdvisor(Integer id) {
        return advisorDao.getAdvisor(id);
    }
    
    @Override
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }

}
