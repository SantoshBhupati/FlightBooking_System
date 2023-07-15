package com.akshada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.akshada.exception.ResourceNotFoundException;
import com.akshada.model.FlightDetails;
import com.akshada.repository.FlightRepo;
import com.akshada.service.FlightService;

class FlightServiceTest {

	@Mock
	private FlightRepo trepo;

	@InjectMocks
	private FlightService flightService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddFlight() {
		// Arrange
		FlightDetails flight = new FlightDetails();
		flight.setId(1);
		when(trepo.save(any(FlightDetails.class))).thenReturn(flight);

		// Act
		FlightDetails savedFlight = flightService.addFlight(flight);

		// Assert
		assertEquals(flight, savedFlight);
		verify(trepo, times(1)).save(flight);
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
		List<FlightDetails> retrievedFlights = flightService.showFlight();

		// Assert
		assertEquals(flights, retrievedFlights);
		verify(trepo, times(1)).findAll();
	}

	@Test
	void testUpdateFlight() throws ResourceNotFoundException {
		// Arrange
		int id = 1;
		String newDestination = "New Destination";
		FlightDetails existingFlight = new FlightDetails();
		existingFlight.setId(id);
		existingFlight.setDestination("Old Destination");
		Optional<FlightDetails> optionalFlight = Optional.of(existingFlight);
		when(trepo.findById(id)).thenReturn(optionalFlight);
		when(trepo.save(any(FlightDetails.class))).thenReturn(existingFlight);

		// Act
		FlightDetails updatedFlight = flightService.updateFlight(id, newDestination);

		// Assert
		assertEquals(newDestination, updatedFlight.getDestination());
		verify(trepo, times(1)).findById(id);
		verify(trepo, times(1)).save(existingFlight);
	}

	@Test
	void testUpdateFlight_ThrowsResourceNotFoundException() {
		// Arrange
		int id = 1;
		when(trepo.findById(id)).thenReturn(Optional.empty());

		// Act and Assert
		assertThrows(ResourceNotFoundException.class, () -> flightService.updateFlight(id, "New Destination"));
		verify(trepo, times(1)).findById(id);
		verify(trepo, never()).save(any(FlightDetails.class));
	}

	@Test
	void testDeleteFlight() throws ResourceNotFoundException {
		// Arrange
		int id = 1;
		FlightDetails existingFlight = new FlightDetails();
		existingFlight.setId(id);
		Optional<FlightDetails> optionalFlight = Optional.of(existingFlight);
		when(trepo.findById(id)).thenReturn(optionalFlight);

		// Act
		String result = flightService.deleteFlight(id);

		// Assert
		assertEquals("Deleted Successfully", result);
		verify(trepo, times(1)).findById(id);
		verify(trepo, times(1)).delete(existingFlight);
	}

	@Test
	void testDeleteFlight_ThrowsResourceNotFoundException() {
		// Arrange
		int id = 1;
		when(trepo.findById(id)).thenReturn(Optional.empty());

		// Act and Assert
		assertThrows(ResourceNotFoundException.class, () -> flightService.deleteFlight(id));
		verify(trepo, times(1)).findById(id);
		verify(trepo, never()).delete(any(FlightDetails.class));
	}
}
