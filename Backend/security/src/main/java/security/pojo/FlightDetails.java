package security.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flightdetails")
public class FlightDetails {
	private int id;
	private String name;
	private int flightNo;
	private String boardingStation;
	private String destination;
	private String timingAndDate;
	private double fair;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getBoardingStation() {
		return boardingStation;
	}

	public void setBoardingStation(String boardingStation) {
		this.boardingStation = boardingStation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTimingAndDate() {
		return timingAndDate;
	}

	public void setTimingAndDate(String timingAndDate) {
		this.timingAndDate = timingAndDate;
	}

	public double getFair() {
		return fair;
	}

	public void setFair(double fair) {
		this.fair = fair;
	}

	public FlightDetails(int id, String name, int flightNo, String boardingStation, String destination,
			String timingAndDate, double fair) {
		super();
		this.id = id;
		this.name = name;
		this.flightNo = flightNo;
		this.boardingStation = boardingStation;
		this.destination = destination;
		this.timingAndDate = timingAndDate;
		this.fair = fair;
	}

	public FlightDetails() {
		super();
	}

}
