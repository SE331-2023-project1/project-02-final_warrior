package se331.proj.rest.service;

import org.springframework.data.domain.Page;

import se331.proj.rest.entity.Advisor;

public interface AdvisorService {
    Integer getAdvisorSize();
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Integer id);
    Advisor save(Advisor advisor);
}