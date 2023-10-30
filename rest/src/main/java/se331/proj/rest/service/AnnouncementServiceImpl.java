package se331.proj.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.dao.AnnouncementDao;
import se331.proj.rest.entity.Announcement;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService{
   final AnnouncementDao announcementDao;

   @Override
   public Page<Announcement> getAnnouncements() {
      return announcementDao.getAnnouncements();
   }

   @Override
   public Announcement getAnnouncementById(Long id) {
      return announcementDao.getAnnouncementById(id);
   }

   @Override
   public Page<Announcement> getAnnouncementsByAdvisorId(Long id) {
      return announcementDao.getAnnouncementsByAdvisorId(id);
   }

   @Override
   public Announcement postAnnouncement(Announcement announcement) {
      return announcementDao.postAnnouncement(announcement);
   }
   
}
