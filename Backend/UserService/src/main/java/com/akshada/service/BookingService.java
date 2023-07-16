package com.akshada.service;

//import java.sql.Date;
//import java.util.Date;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.Booking;
import com.akshada.model.FlightDetails;
import com.akshada.repository.BookingRepo;
import com.akshada.repository.FlightRepo;

import mailservice.EmailServiceImpl;

@Service
public class BookingService implements UserServiceImpl{
	
	private static final Logger log = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private BookingRepo brepo;
	
	@Autowired
	private FlightRepo trepo;

	@Autowired
	private EmailServiceImpl esi;

	@Autowired
	SequenceGeneratorService seq;
	@Override
	public List<FlightDetails> showFlight() {
		return trepo.findAll();
	}


	@Override
	public Booking showBookingById(int id) throws ResourceNotFoundException {
		Optional<Booking> book = brepo.findById(id);
		if(book.isEmpty()) {
			log.info("booking not found by the given ID"+id);
			throw new ResourceNotFoundException("not found");
		}
		Booking bk = book.get();
		return bk;
	}

	@Override
	public Booking showBookingByName(String name) throws ResourceNotFoundException {
		Booking book = brepo.findAllByFirstName(name);
		if(book == null) {
			log.info("booking not found by the given name "+name);
			throw new ResourceNotFoundException("not found");
		}
		return book;
	}


	@Override
	public Booking bookFlight(Booking book) {
		FlightDetails td = trepo.findByName(book.getFlightName().toLowerCase());
		
		book.setId(seq.getSequenceNum(Booking.sequenceName));
		Map<String, Double> tt = getMap();
		String trainname = book.getFlightName();
		double fair = tt.get(trainname);
		book.setFair(fair * book.getNumberOfTravellers());
		Booking bk = brepo.save(book);
		String body = "Hello "+book.getFirstName()+" "+book.getLastName()+" ,We have received your booking for ID:"+book.getId()+""
				+ "\n Boarding Station: "+book.getSource()+""
				+ "\n Destination: "+book.getDestination()+""
				+ "\n flight Name: "+book.getFlightName()+""+
//				"\n flight Timing And Date: "+td.getTimingAndDate()+
				"\n Please Proceed to make payment for the Total Amount of Rs "+bk.getFair();
		esi.sendSimpleMail(book.getEmail(), body, "Booking Details");
		log.info("Booking successfully done for ID"+book.getId());
		return bk;
	}
	
	public Map getMap() {
		Map<String, Double> Tickets = new HashMap<>();
		Tickets.put("air asia", 4000.00);
		Tickets.put("indigo", 3000.00);
		Tickets.put("air india", 1800.00);
		Tickets.put("spicejet", 5000.00);
	    return Tickets;
	}
	public List<FlightDetails> showflight(String boardingStation, String destination) {
		// TODO Auto-generated method stub
		List<FlightDetails> obj=trepo.findByBoardingStationAndDestination(boardingStation,destination);
		return obj;
	}
	@Override
	public Booking cancelTicket(int id) throws ResourceNotFoundException{
//		Optional<Booking> deleteBooking = brepo.findById(id);
//		if(deleteBooking.isEmpty()) {
//			throw new ResourceNotFoundException("Booking not fount by the given Id" +id);
//		}
//		Booking cancel = deleteBooking.get();
//		String Flightname = cancel.getFlightName();
//		FlightDetails td = brepo.findByFlightName(Flightname);
////		td.setTicketsAvailable(cancel.getNumberOfTravellers());
//		trepo.save(td);
//		brepo.delete(cancel);
//		String body = "Hello "+cancel.getFirstName()+" "+cancel.getLastName()+" ,We have Cancelled your booking for ID:"+cancel.getId()+"";
//		esi.sendSimpleMail(cancel.getEmail(), body, "Booking Details");
//		return cancel;
		  Optional<Booking> deleteBooking = brepo.findById(id);
		    if (deleteBooking.isEmpty()) {
		        throw new ResourceNotFoundException("Booking not found by the given Id: " + id);
		    }
		    Booking cancel = deleteBooking.get();

		    // Delete the document using the ID
		    brepo.deleteById(cancel.getId());

		    String body = "Hello " + cancel.getFirstName() + " " + cancel.getLastName() + ", We have cancelled your booking for ID: " + cancel.getId();
		    esi.sendSimpleMail(cancel.getEmail(), body, "Booking Details");

		    return cancel;
	}
}
