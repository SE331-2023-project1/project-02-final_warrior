package se331.proj.rest.dao;

import java.util.List;

import se331.proj.rest.entity.Advisor;

public interface AdvisorDao {
    Integer getAdvisorSize();
    List<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Integer id);
}
