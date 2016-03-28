package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Person;

public class Customer extends Person implements _Customer {

	private Address custAddress;

	public Customer(){
		
	}
	
	public Customer(long id, String first, String last, String body, String extension, String email, Address custAddress){
		super(id, first, last, body, extension, email);
		this.custAddress = custAddress;
	}
	
	public Address getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		if (!custAddress.verify()) return false;
		return true;
	}

}
