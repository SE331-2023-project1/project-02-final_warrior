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
public class AdvisorDTO {
    Integer id;
    Integer advisorId;
    String name;
    String surname;
    @ElementCollection
    List<String> imageLink;
    String dept;
    String position;
    @Builder.Default
    List<AdvisorStudentDTO> students = new ArrayList<>();

    String username;
    List<Role> roles = new ArrayList<>();
}
