package se331.proj.rest.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import se331.proj.rest.entity.Organizer;
//import se331.proj.rest.entity.OrganizerAuthDTO;
//import se331.proj.rest.entity.OrganizerDTO;
import se331.proj.rest.security.user.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("user_role")
  private List<Role> userRole;
  @JsonProperty("student_id")   
  private Long studentid;
  @JsonProperty("advisor_id")   
  private Long advisorid;
//  private OrganizerAuthDTO user;
}
