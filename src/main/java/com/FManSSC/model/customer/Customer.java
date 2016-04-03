package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Person;

public class Customer extends Person implements _Customer {

	private Address address;
	private boolean addressSet = false;

	public Customer(){
		
	}
	
	public Customer(long id, String first, String last, String body, String extension, String email, Address address){
		super(id, first, last, body, extension, email);
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		addressSet = true;
	}

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		if (!addressSet) return false;
		return true;
	}
}
