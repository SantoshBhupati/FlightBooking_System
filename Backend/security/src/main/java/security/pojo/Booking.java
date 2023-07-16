package security.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "Booking")
public class Booking {
	
	@Transient
	public  static final String sequenceName="BookingSequence";

	@Id
	@NotEmpty
	private int id;
	@NotEmpty(message = "Name shoud not be empty")
	private String firstName;
	private String lastName;
	@NotEmpty(message = "Email shoud not be empty")
	private String email;
	private String flightName;
	private String source;
	private String destination;
	@NotEmpty(message = "Travellers shoud not be empty")
	private int numberOfTravellers;
	private double fair;

	public Booking(@NotEmpty int id, String firstName, String lastName, String email, String flightName, String source,
			String destination, int numberOfTravellers, double fair) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.numberOfTravellers = numberOfTravellers;
		this.fair = fair;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberOfTravellers() {
		return numberOfTravellers;
	}

	public void setNumberOfTravellers(int numberOfTravellers) {
		this.numberOfTravellers = numberOfTravellers;
	}

	public double getFair() {
		return fair;
	}

	public void setFair(double fair) {
		this.fair = fair;
	}

}
