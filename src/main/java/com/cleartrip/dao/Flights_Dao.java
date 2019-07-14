package com.cleartrip.dao;

public class Flights_Dao {

	private String triptype;
	private String from;
	private String to;
	private String departon; // it should be date format type
	private String adults;
	private String children;
	private String infants;
	
	//Setters
	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setDeparton(String departon) {
		this.departon = departon;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public void setInfants(String infants) {
		this.infants = infants;
	}
	
	//getters
	public String getTriptype() {
		return triptype;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getDeparton() {
		return departon;
	}
	public String getAdults() {
		return adults;
	}
	public String getInfants() {
		return infants;
	}

	public String getChildren() {
		return children;
	}

	
	

	
}
