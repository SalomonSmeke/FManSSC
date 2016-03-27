package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Person;

public class Customer extends Person implements _Customer {

	private Address custAddress;

	public Address getAddress() {
		return custAddress;
	}
	public void setAddress(Address address) {
		this.custAddress = address;
	}

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		if (!custAddress.verify()) return false;
		return true;
	}

}
