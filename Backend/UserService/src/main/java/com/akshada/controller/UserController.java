package com.akshada.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.Booking;
import com.akshada.service.BookingService;

@RestController
public class UserController {

	@Autowired
	private BookingService bk;

	@PostMapping("/book")
	public ResponseEntity<?> bookFlight(@RequestBody Booking book) {
		return ResponseEntity.ok(bk.bookFlight(book));
	}

	@GetMapping("/show")
	public ResponseEntity<?> showFlight() {
		return ResponseEntity.ok(bk.showFlight());
	}

	@GetMapping("/findbyId/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(bk.showBookingById(id));
	}
	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) throws ResourceNotFoundException {
		return ResponseEntity.ok(bk.showBookingByName(name));
	}
	@GetMapping("findbysourceanddestination/{boardingStation}/{destination}")
	public ResponseEntity<?> searchflight(@PathVariable String boardingStation,@PathVariable String destination )
	{
//		return ResponseEntity.ok(bk.showflight(boardingStation,destination));
		return ResponseEntity.ok(bk.showflight(boardingStation,destination));
	}
	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<?> cancelBooking(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(bk.cancelTicket(id));
	}
}
