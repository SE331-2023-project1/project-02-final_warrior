package se331.proj.rest.service;

import java.util.List;

import se331.proj.rest.entity.Advisor;

public interface AdvisorService {
    Integer getAdvisorSize();
    List<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Integer id);
}