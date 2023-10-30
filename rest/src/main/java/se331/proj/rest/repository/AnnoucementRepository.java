package se331.proj.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.proj.rest.entity.Announcement;

public interface AnnoucementRepository extends JpaRepository<Announcement, Long> {
   Page<Announcement> findByAdvisor_Id(Long id, Pageable pageable);
}
