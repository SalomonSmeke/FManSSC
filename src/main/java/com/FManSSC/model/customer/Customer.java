package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Person;
import com.FManSSC.model.backbones._Synopsis;
import com.FManSSC.model.backbones._Verifiable;

public class Customer extends Person implements _Customer, _Synopsis, _Verifiable {

	private Address address;

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
	}
	
	@Override
	public String synopsis(){
		if (verify()){
			String superS = super.synopsis();
			return superS + ". " + address.synopsis();
		} else {
			return "Object Incomplete";
		}
	}

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		if (!address.verify()) return false;
		return true;
	}
}
