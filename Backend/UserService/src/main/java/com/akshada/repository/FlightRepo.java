package com.akshada.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.FlightDetails;


@Repository
public interface FlightRepo extends MongoRepository<FlightDetails, Integer>{
	
	FlightDetails findByName(String name);
	List<FlightDetails> findByBoardingStationAndDestination(String boardingStation, String destination);
//	FlightDetails findByFlightName(String flightname)throws ResourceNotFoundException;;
}
