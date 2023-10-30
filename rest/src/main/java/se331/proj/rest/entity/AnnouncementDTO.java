package se331.proj.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
   Long id;
   String message;
   String file;
   String name;
   String surname;
   AdvisorStudentDTO advisor;
}