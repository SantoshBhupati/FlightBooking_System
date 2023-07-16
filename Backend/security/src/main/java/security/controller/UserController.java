package security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshada.exception.ResourceNotFoundException;

import security.proxy.UserProxy;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserProxy userproxy;
	
	@PostMapping(value = "/book",produces = "application/json")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> bookFlight(@RequestBody security.pojo.Booking book,@RequestHeader("Authorization") String authorization) {
		return userproxy.bookFlight(book, authorization);
	}

	@GetMapping(value = "/show",produces = "application/json")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> showFlight(@RequestHeader("Authorization") String authorization) {
		return userproxy.showFlight(authorization);
	}

	@GetMapping(value = "/findbyId/{id}",produces = "application/json")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> findById(@PathVariable int id,@RequestHeader("Authorization") String authorization) throws ResourceNotFoundException {
		return userproxy.findById(id,authorization);
	}
	
	@GetMapping(value = "/findbyname/{name}",produces = "application/json")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> findById(@PathVariable String name,@RequestHeader("Authorization") String authorization) throws ResourceNotFoundException {
		return userproxy.findByName(name,authorization);
	}

}
