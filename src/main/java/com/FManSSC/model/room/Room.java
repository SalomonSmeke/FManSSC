package com.FManSSC.model.room;

import com.FManSSC.model.facility.Facility;

public class Room implements _Room {

	private long id;
	private boolean idSet = false;
	private Facility facility;
	private int capacity;
	private boolean capacitySet = false;
	private double costPerHr;
	private boolean costPerHrSet = false;

	private String number;
	private String location;
	private String description;

	private boolean active = true;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		capacitySet = true;
	}
	public double getCostPerHr() {
		return costPerHr;
	}
	public void setCostPerHr(double costPerHr) {
		this.costPerHr = costPerHr;
		costPerHrSet = true;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void appendDescription(String description) {
		this.description += description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!facility.verify()) return false;
		if (!capacitySet) return false;
		if (!costPerHrSet) return false;
		return true;
	}
}
