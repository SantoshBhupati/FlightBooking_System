package com.akshada.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akshada.model.Booking;
import com.akshada.model.FlightDetails;

public interface BookingRepo extends MongoRepository<Booking, Integer> {
	
	Booking findAllByFirstName(String name);

	FlightDetails findByFlightName(String flightname);

}
