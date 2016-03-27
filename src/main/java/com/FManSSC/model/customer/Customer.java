package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Person;

public class Customer extends Person implements _Customer {

	private Address address;

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		if (!address.verify()) return false;
		return true;
	}

}
