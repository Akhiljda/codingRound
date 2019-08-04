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
		System.out.println("Flights_Dao setTriptype: Begin!");
		this.triptype = triptype;
		System.out.println("Flights_Dao setTriptype: End!");
	}
	public void setFrom(String from) {
		System.out.println("Flights_Dao setFrom: Begin!");
		this.from = from;
		System.out.println("Flights_Dao setFrom: Begin!");
	}
	public void setTo(String to) {
		System.out.println("Flights_Dao setTo: Begin!");
		this.to = to;
		System.out.println("Flights_Dao setTo: End!");
	}
	public void setDeparton(String departon) {
		System.out.println("Flights_Dao setDeparton: Begin!");
		this.departon = departon;
		System.out.println("Flights_Dao setDeparton: End!");
	}
	public void setAdults(String adults) {
		System.out.println("Flights_Dao setAdults: Begin!");
		this.adults = adults;
		System.out.println("Flights_Dao setAdults: End!");
	}
	public void setChildren(String children) {
		System.out.println("Flights_Dao setChildren: Begin!");
		this.children = children;
		System.out.println("Flights_Dao setChildren: Begin!");
	}
	public void setInfants(String infants) {
		System.out.println("Flights_Dao setInfants: Begin!");
		this.infants = infants;
		System.out.println("Flights_Dao setInfants: End!");
	}
	
	//getters
	public String getTriptype() {
		System.out.println("Flights_Dao getTriptype: Begin!");
		return triptype;
		
	}
	public String getFrom() {
		System.out.println("Flights_Dao getFrom: Begin!");
		return from;
	}
	public String getTo() {
		System.out.println("Flights_Dao getTo: Begin!");
		return to;
	}
	public String getDeparton() {
		System.out.println("Flights_Dao getDeparton: Begin!");
		return departon;
	}
	public String getAdults() {
		System.out.println("Flights_Dao getAdults: Begin!");
		return adults;
	}
	public String getInfants() {
		System.out.println("Flights_Dao getInfants: Begin!");
		return infants;
	}

	public String getChildren() {
		System.out.println("Flights_Dao getChildren: Begin!");
		return children;
	}

	
	

	
}
