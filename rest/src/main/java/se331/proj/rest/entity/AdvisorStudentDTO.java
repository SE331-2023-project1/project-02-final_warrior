package se331.proj.rest.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorStudentDTO {
    Integer id;
    Integer studentId;
    String name;
    String surname;
    @ElementCollection
    List<String> imageLink;
    String dept;
}