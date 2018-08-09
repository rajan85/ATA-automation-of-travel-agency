package com.ata.bean;

public class RouteBean {
	private String routeID;
	private String source;
	private String destination;
	private int distance;
	private double travelDuration;
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public double getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(double travelDuration) {
		this.travelDuration = travelDuration;
	}
	
}
