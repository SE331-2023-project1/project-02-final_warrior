package se331.proj.rest.service;

import org.springframework.data.domain.Page;

import se331.proj.rest.entity.Announcement;

public interface AnnouncementService {
   Page<Announcement> getAnnouncements();
   Announcement getAnnouncementById(Long id);
   Page<Announcement> getAnnouncementsByAdvisorId(Long id);
   Announcement postAnnouncement(Announcement announcement);
}
