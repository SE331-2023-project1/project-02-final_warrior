package se331.proj.rest.entity;

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
    String imageLink;
    String dept;
}