package se331.proj.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se331.proj.rest.entity.Advisor;

public interface AdvisorRepository extends CrudRepository<Advisor,Integer> {
    List<Advisor> findAll();
}
