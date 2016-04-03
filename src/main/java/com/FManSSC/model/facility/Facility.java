package com.FManSSC.model.facility;

import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.backbones.Phone;

public class Facility implements _Facility {

	private long id;
	private boolean idSet = false;
	private long ownerId;
	private boolean ownerIdSet = false;

	private Address address;
	private boolean addressSet = false;

	private String body;
	private String extension;
	private String description;

	private boolean active = true;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
		ownerIdSet = true;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		addressSet = true;
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

	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!ownerIdSet) return false;
		if (!addressSet) return false;
		Phone tempPhone = new Phone();
		tempPhone.setBody(body);
		tempPhone.setExtension(extension);
		if (!tempPhone.verify()) return false;
		return true;
	}

}
