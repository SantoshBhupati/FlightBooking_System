package security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER')")          
  public String userAccess() {
    return "User Content.";
  }
  @GetMapping("/attendee")
  @PreAuthorize("hasRole('ATTENDEE')")
  public String attendeeAccess() {
    return "Attendee Board.";
  }
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN') or hasRole('ATTENDEE')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
