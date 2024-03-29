package com.FManSSC.model.backbones;

public class Address implements _Verifiable, _Synopsis{

	private long id;
	private boolean idSet = false;
	private int streetNo;
	private boolean streetNoSet = false;

	private String street = "";
	private String zip = "";
	private String city = "";
	private String state = "";

	public Address(){

	}
	
	public Address(long id, int streetNo, String street, String zip, String city, String state){
		this.id = id;
		this.idSet = true;
		this.streetNo = streetNo;
		this.streetNoSet = true;
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.state = state;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}

	public int getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
		streetNoSet = true;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isIdSet() {
		return idSet;
	}

	public void setIdSet(boolean idSet) {
		this.idSet = idSet;
	}

	public boolean isStreetNoSet() {
		return streetNoSet;
	}

	public void setStreetNoSet(boolean streetNoSet) {
		this.streetNoSet = streetNoSet;
	}

	public String synopsis(){
		if (verify()){
			String streetSyn = street.substring(0, Math.min(street.length(), 10));
			return (streetSyn + ", #" + streetNo + " " + zip);
		} else {
			return "Object Incomplete";
		}
	}
	
	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!streetNoSet) return false;
		if (street.length()==0) return false;
		if (zip.length()!=5) return false;
		if (city.length()==0) return false;
		if (state.length()==0) return false;
		return true;
	}
}
