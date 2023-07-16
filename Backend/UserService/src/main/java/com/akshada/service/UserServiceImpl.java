package com.akshada.service;

import java.util.List;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.Booking;
import com.akshada.model.FlightDetails;

public interface UserServiceImpl {
	List<FlightDetails> showFlight();
	Booking bookFlight(Booking book);
	Booking showBookingById(int id)throws ResourceNotFoundException;
	Booking showBookingByName(String name) throws ResourceNotFoundException;
//	Booking cancelTicket(int id)throws ResourceNotFoundException;
	Booking cancelTicket(int id) throws ResourceNotFoundException;
}
