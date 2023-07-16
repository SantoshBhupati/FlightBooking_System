package com.akshada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.Booking;
import com.akshada.model.FlightDetails;
import com.akshada.repository.BookingRepo;
import com.akshada.repository.FlightRepo;
import com.akshada.service.BookingService;
import com.akshada.service.SequenceGeneratorService;

import mailservice.EmailServiceImpl;

class BookingServiceTest {

	@Mock
	private BookingRepo brepo;

	@Mock
	private FlightRepo trepo;

	@Mock
	private EmailServiceImpl esi;

	@Mock
	private SequenceGeneratorService seq;

	@InjectMocks
	private BookingService bookingService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testShowFlight() {
		// Arrange
		List<FlightDetails> flights = new ArrayList<>();
		FlightDetails flight1 = new FlightDetails();
		flight1.setId(1);
		flights.add(flight1);
		FlightDetails flight2 = new FlightDetails();
		flight2.setId(2);
		flights.add(flight2);
		when(trepo.findAll()).thenReturn(flights);

		// Act
		List<FlightDetails> retrievedFlights = bookingService.showFlight();

		// Assert
		assertEquals(flights, retrievedFlights);
		verify(trepo, times(1)).findAll();
	}

	@Test
	void testShowBookingById() throws ResourceNotFoundException {
		// Arrange
		int id = 1;
		Booking booking = new Booking();
		booking.setId(id);
		Optional<Booking> optionalBooking = Optional.of(booking);
		when(brepo.findById(id)).thenReturn(optionalBooking);

		// Act
		Booking retrievedBooking = bookingService.showBookingById(id);

		// Assert
		assertEquals(booking, retrievedBooking);
		verify(brepo, times(1)).findById(id);
	}

	@Test
	void testShowBookingById_ThrowsResourceNotFoundException() {
		// Arrange
		int id = 1;
		when(brepo.findById(id)).thenReturn(Optional.empty());

		// Act and Assert
		assertThrows(ResourceNotFoundException.class, () -> bookingService.showBookingById(id));
		verify(brepo, times(1)).findById(id);
	}

	@Test
	void testShowBookingByName() throws ResourceNotFoundException {
		// Arrange
		String name = "John Doe";
		Booking booking = new Booking();
		booking.setId(1);
		when(brepo.findAllByFirstName(name)).thenReturn(booking);

		// Act
		Booking retrievedBooking = bookingService.showBookingByName(name);

		// Assert
		assertEquals(booking, retrievedBooking);
		verify(brepo, times(1)).findAllByFirstName(name);
	}

	@Test
	void testShowBookingByName_ThrowsResourceNotFoundException() {
		// Arrange
		String name = "John Doe";
		when(brepo.findAllByFirstName(name)).thenReturn(null);

		// Act and Assert
		assertThrows(ResourceNotFoundException.class, () -> bookingService.showBookingByName(name));
		verify(brepo, times(1)).findAllByFirstName(name);
	}

	@Test
	void testBookFlight() {
	    // Arrange
	    Booking booking = new Booking();
	    booking.setId(1);
	    booking.setFlightName("air asia");
	    booking.setNumberOfTravellers(2);
	    booking.setSource("Source");
	    booking.setDestination("Destination");
	    booking.setFirstName("John");
	    booking.setLastName("Doe");
	    booking.setEmail("john.doe@example.com");

	    FlightDetails flightDetails = new FlightDetails();
	    flightDetails.setName("air asia");
//	    flightDetails.setTimingAndDate("10:00 AM, 2023-07-03");

	    Map<String, Double> fairMap = new HashMap<>();
	    fairMap.put("air asia", 4000.00);

	    when(trepo.findByName("air asia")).thenReturn(flightDetails);
	    when(seq.getSequenceNum(Booking.sequenceName)).thenReturn(1);
	    doNothing().when(esi).sendSimpleMail(anyString(), anyString(), anyString());
	    when(brepo.save(any(Booking.class))).thenReturn(booking);

	    // Act
	    Booking bookedFlight = bookingService.bookFlight(booking);

	    // Assert
	    assertEquals(booking.getId(), bookedFlight.getId());
	    assertEquals(4000.00 * 2, bookedFlight.getFair());
	    verify(trepo, times(1)).findByName("air asia");
	    verify(seq, times(1)).getSequenceNum(Booking.sequenceName);
	    verify(esi, times(1)).sendSimpleMail(anyString(), anyString(), anyString());
	    verify(brepo, times(1)).save(booking);
	}



	@Test
	void testGetMap() {
		// Arrange
		Map<String, Double> expectedMap = new HashMap<>();
		expectedMap.put("air asia", 4000.00);
		expectedMap.put("indigo", 3000.00);
		expectedMap.put("air india", 1800.00);
		expectedMap.put("spicejet", 5000.00);

		// Act
		Map<String, Double> resultMap = bookingService.getMap();

		// Assert
		assertEquals(expectedMap, resultMap);
	}
}
