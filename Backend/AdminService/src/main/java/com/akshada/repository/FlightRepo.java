package com.akshada.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akshada.model.FlightDetails;


@Repository
public interface FlightRepo extends MongoRepository<FlightDetails, Integer>{
	
	FlightDetails findByName(String name);
}
