package com.FManSSC.model.customer;

import com.FManSSC.model.backbones.Person;

public class Customer extends Person implements _Customer {

	private long address;
	private boolean addressSet = false;

	public Customer(){
		
	}
	
	public Customer(long id, String first, String last, String body, String extension, String email, long address){
		super(id, first, last, body, extension, email);
		this.address = address;
	}
	
	public long getAddressId() {
		return address;
	}
	public void setAddressId(long address) {
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
