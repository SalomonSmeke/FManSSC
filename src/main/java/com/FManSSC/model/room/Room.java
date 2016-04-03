package com.FManSSC.model.room;

import com.FManSSC.model.backbones._Synopsis;
import com.FManSSC.model.backbones._Verifiable;
import com.FManSSC.model.facility.Facility;

public class Room implements _Room, _Verifiable, _Synopsis {

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

	public Room(){
		
	}
	
	public Room(long id, Facility facility, int capacity, double costPerHr, String number, String location, String description,boolean active){
		this.id=id;
		this.idSet=true;
		this.facility=facility;
		this.capacity=capacity;
		this.capacitySet=true;
		this.costPerHr=costPerHr;
		this.costPerHrSet=true;
		this.number=number;
		this.location=location;
		this.description=description;
		this.active=active;
	}
	
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
	
	public boolean isIdSet() {
		return idSet;
	}
	public void setIdSet(boolean idSet) {
		this.idSet = idSet;
	}
	public boolean isCapacitySet() {
		return capacitySet;
	}
	public void setCapacitySet(boolean capacitySet) {
		this.capacitySet = capacitySet;
	}
	public boolean isCostPerHrSet() {
		return costPerHrSet;
	}
	public void setCostPerHrSet(boolean costPerHrSet) {
		this.costPerHrSet = costPerHrSet;
	}
	@Override
	public String synopsis(){
		if (verify()){
			String facS = facility.synopsis();
			return "#" + number + " Capacity:" + capacity + " $/hr:" + costPerHr + "Exists?: " + active + " " + facS;
		} else {
			return "Object Incomplete";
		}
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
