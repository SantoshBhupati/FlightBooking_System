package com.akshada.model;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
@Document(collection = "flightdetails")
public class FlightDetails {
	@Transient
	public  static final String sequenceName="FlightSequence";
	
	 private int id;
	    private String name;
	    private int flightNo;
	    private String boardingStation;
	    private String destination;
	    private String timing;
//	    private Date date;
	    @JsonFormat(shape = JsonFormat.Shape.STRING)
		private LocalDate date;
	    private int fair;
	    private String _class;

	    public FlightDetails() {
	    }

	    public FlightDetails(int id, String name, int flightNo, String boardingStation, String destination, String timing, LocalDate date, int fair, String _class) {
	        this.id = id;
	        this.name = name;
	        this.flightNo = flightNo;
	        this.boardingStation = boardingStation;
	        this.destination = destination;
	        this.timing = timing;
	        this.date = date;
	        this.fair = fair;
	        this._class = _class;
	    }

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

	    public String getTiming() {
	        return timing;
	    }

	    public void setTiming(String timing) {
	        this.timing = timing;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public int getFair() {
	        return fair;
	    }

	    public void setFair(int fair) {
	        this.fair = fair;
	    }

	    public String get_class() {
	        return _class;
	    }

	    public void set_class(String _class) {
	        this._class = _class;
	    }


}