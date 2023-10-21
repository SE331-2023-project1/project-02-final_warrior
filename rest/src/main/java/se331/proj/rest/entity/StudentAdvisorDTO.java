package se331.proj.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdvisorDTO {
    Integer id;
    Integer advisorId;
    String name;
    String surname;
    String imageLink;
    String dept;
    String position;
}