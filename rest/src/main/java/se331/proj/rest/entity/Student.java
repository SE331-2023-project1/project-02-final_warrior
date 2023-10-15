package se331.proj.rest.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    Long id;
    Integer studentId;
    String name;
    String surname;
    String imageLink;
    String dept;
    Integer advisorId;
}
