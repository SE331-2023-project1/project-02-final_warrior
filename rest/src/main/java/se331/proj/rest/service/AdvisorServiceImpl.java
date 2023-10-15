package se331.proj.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.AdvisorDao;
import se331.proj.rest.entity.Advisor;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{
    final AdvisorDao AdvisorDao;
    @Override
    public Integer getAdvisorSize(){
        return AdvisorDao.getAdvisorSize();
    }

    @Override
    public List<Advisor> getAdvisors(Integer perPage, Integer page) {
        return AdvisorDao.getAdvisors(perPage, page);
    }

    @Override
    public Advisor getAdvisor(Integer id) {
        return AdvisorDao.getAdvisor(id);
    }
}
