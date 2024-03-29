package com.FManSSC.model.facility;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Phone;
import com.FManSSC.model.backbones._Synopsis;
import com.FManSSC.model.backbones._Verifiable;
import com.FManSSC.model.owner.Owner;

public class Facility implements _Facility, _Synopsis, _Verifiable {

	private long id;
	private boolean idSet = false;
	private Owner owner;

	private Address address;

	private String body;
	private String extension;
	private String description;

	private boolean active = true;

	public Facility(){
		
	}
	public Facility(long id, Owner owner, Address address, String body, String extension, String description, Boolean active){
		this.id = id;
		this.idSet = true;
		this.owner = owner;
		this.address = address;
		this.body = body;
		this.extension = extension;
		this.description = description;
		this.active = active;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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
	@Override
	public String synopsis(){
		if (verify()){
			return (owner.synopsis() + ". Owns:" + body + " " + address.synopsis() + ". Active?: " + active);
		} else {
			return "Object Incomplete";
		}
	}

	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!owner.verify()) return false;
		if (!address.verify()) return false;
		Phone tempPhone = new Phone();
		tempPhone.setBody(body);
		tempPhone.setExtension(extension);
		if (!tempPhone.verify()) return false;
		return true;
	}

}
