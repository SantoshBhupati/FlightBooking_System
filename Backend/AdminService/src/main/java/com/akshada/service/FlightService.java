package com.akshada.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshada.exception.ResourceNotFoundException;
//import com.akshada.model.Booking;
//import com.akshada.model.Booking;
import com.akshada.model.FlightDetails;
import com.akshada.repository.FlightRepo;

@Service
public class FlightService implements FlightServiceImpl{
	
	private static final Logger log = LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private FlightRepo trepo;
	@Autowired
	private SequenceGeneratorService seq;
	@Override
	public FlightDetails addFlight(FlightDetails td) {
//		FlightDetails book = new FlightDetails();
		td.setId(seq.getSequenceNum(FlightDetails.sequenceName));
		FlightDetails save = trepo.save(td);
		return save;
	}

	@Override
	public List<FlightDetails> showFlight() {
		return trepo.findAll();
	}

	@Override
	public FlightDetails updateFlight(int id, String destination) throws ResourceNotFoundException {
		Optional<FlightDetails> td = trepo.findById(id);
		if(td.isEmpty()) {
			log.warn("Flight with the specified Id is not avvailable" +id);
			throw new ResourceNotFoundException("Flight with the following Id Does not Exist " +id);
		}
		FlightDetails tds = td.get();
		tds.setDestination(destination);
		FlightDetails save = trepo.save(tds);
		return save;
	}
	@Override
	public FlightDetails update_Flight_all(int id, FlightDetails flight) {
		Optional<FlightDetails> t = trepo.findById(id);
		FlightDetails tr = t.get();
		tr.setName(flight.getName());
		tr.setFlightNo(flight.getFlightNo());
		tr.setBoardingStation(flight.getBoardingStation());
		tr.setDestination(flight.getDestination());
		tr.setDate(flight.getDate());
		tr.setFair(flight.getFair());
		tr.setTiming(flight.getTiming());
//		tr.setTicketsAvailable(train.getTicketsAvailable());
		trepo.save(tr);
		return tr;
	}

	@Override
	public String deleteFlight(int id) throws ResourceNotFoundException {
		Optional<FlightDetails> td = trepo.findById(id);
		if(td.isEmpty()) {
			throw new ResourceNotFoundException("Flight with the following Id Does not Exist " +id);
		}
		FlightDetails tds = td.get();
		trepo.delete(tds);
		return "Deleted Successfully";
	}

}
