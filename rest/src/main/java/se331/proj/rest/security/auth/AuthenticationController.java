package se331.proj.rest.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("advisor/register")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<AuthenticationResponse> advisorRegister(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.advisorRegister(request));
  }
  @PostMapping("/authenticate")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    AuthenticationResponse result = service.authenticate(request);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
