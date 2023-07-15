package com.akshada.service;

import java.util.List;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.FlightDetails;

public interface FlightServiceImpl {
	FlightDetails addFlight(FlightDetails td);
	List<FlightDetails> showFlight();
    FlightDetails updateFlight(int FlightNo, String destination) throws ResourceNotFoundException;
    FlightDetails update_Flight_all(int id, FlightDetails flight);
	String deleteFlight(int id) throws ResourceNotFoundException;
}
