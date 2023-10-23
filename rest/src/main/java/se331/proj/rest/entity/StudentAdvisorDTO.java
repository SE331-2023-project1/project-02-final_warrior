package se331.proj.rest.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.proj.rest.security.user.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdvisorDTO {
    Long id;
    String username;
    String name;
    String surname;
    List<String> images;
    String dept;
    StudentAdvisorDTO advisor;
    List<Role> roles = new ArrayList<>();
}