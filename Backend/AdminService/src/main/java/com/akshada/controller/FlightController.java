package com.akshada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.FlightDetails;
import com.akshada.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService ts; 
	
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody FlightDetails td){
		FlightDetails save = ts.addFlight(td);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/show")
	public ResponseEntity<?> showFlight(){
		return ResponseEntity.ok(ts.showFlight());
	}
	
	@PutMapping("/update/{id}/{destination}")
	public ResponseEntity<?> updateFlight(@PathVariable int id, @PathVariable String destination) throws ResourceNotFoundException{
		return ResponseEntity.ok(ts.updateFlight(id, destination));
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update_Flight(@PathVariable int id,@RequestBody FlightDetails td){
		FlightDetails save = ts.update_Flight_all(id, td);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteFlight(@PathVariable int id) throws ResourceNotFoundException{
		return ts.deleteFlight(id);
	}

}
