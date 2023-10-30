package se331.proj.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Announcement;
import se331.proj.rest.repository.AnnoucementRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouncementDaoImpl implements AnnouncementDao{
   final AnnoucementRepository announcementRepository;

   @Override
   public Page<Announcement> getAnnouncements() {
      return announcementRepository.findAll(Pageable.unpaged());
   }

   @Override
   public Announcement getAnnouncementById(Long id) {
      return announcementRepository.findById(id).orElse(null);
   }

   @Override
   public Page<Announcement> getAnnouncementsByAdvisorId(Long id) {
      return announcementRepository.findByAdvisor_Id(id, Pageable.unpaged());
   }

   @Override
   public Announcement postAnnouncement(Announcement announcement) {
      return announcementRepository.save(announcement);
   }
}
