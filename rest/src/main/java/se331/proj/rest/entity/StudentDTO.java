package se331.proj.rest.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Integer id;
    Integer studentId;
    String name;
    String surname;
    String imageLink;
    String dept;
    StudentAdvisorDTO advisor;
}
