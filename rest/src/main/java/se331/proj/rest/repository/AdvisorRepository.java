package se331.proj.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.proj.rest.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor,Long> {
    List<Advisor> findAll();


}
