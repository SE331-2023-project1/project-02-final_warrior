package se331.proj.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import se331.proj.rest.entity.Announcement;
import se331.proj.rest.service.AnnouncementService;
import se331.proj.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
   final AnnouncementService annoucementService;

   @GetMapping("announcements")
   @CrossOrigin(origins = "http://localhost:3000")
   public ResponseEntity<?> getAnnouncements() {
      Page<Announcement> output = annoucementService.getAnnouncements();
      return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output.getContent()));
   }

   @GetMapping("announcements/{advisorId}")
   @CrossOrigin(origins = "http://localhost:3000")
   public ResponseEntity<?> getAnnouncements(@PathVariable("advisorId") Long id) {
      Page<Announcement> output = annoucementService.getAnnouncementsByAdvisorId(id);
      return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output.getContent()));
   }

   @GetMapping("announcement/{id}")
   @CrossOrigin(origins = "http://localhost:3000")
   public ResponseEntity<?> getAnnouncementById(@PathVariable("id") Long id) {
      Announcement output = annoucementService.getAnnouncementById(id);
      return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output));
   }

   @PostMapping("announcements")
   public ResponseEntity<?> addAnnouncementDTO(@RequestBody Announcement announcement) {
      return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(annoucementService.postAnnouncement(announcement)));
   }
}
