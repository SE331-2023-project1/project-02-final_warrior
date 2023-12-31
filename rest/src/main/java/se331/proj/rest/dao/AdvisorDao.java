package se331.proj.rest.dao;

import org.springframework.data.domain.Page;

import se331.proj.rest.entity.Advisor;

public interface AdvisorDao {
    Integer getAdvisorSize();
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Advisor getAdvisor(Long id);

    Advisor save(Advisor advisor);
}