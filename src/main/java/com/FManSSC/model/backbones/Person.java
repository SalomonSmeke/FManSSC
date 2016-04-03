package com.FManSSC.model.backbones;

import com.FManSSC.dataHelpers.Skeletal;

public abstract class Person implements _Verifiable, _Synopsis {

	private long id;
	private boolean idSet;

	private String first;
	private String last;
	private String body;
	private String extension;
	private String email;

	private boolean active = true;

	public Person(){

	}
	
	public Person(long id, String first, String last, String body, String extension, String email){
		this.id = id;
		this.idSet = true;
		this.first = first;
		this.last = last;
		this.body = body;
		this.extension = extension;
		this.email = email;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public String synopsis(){
		if (verify()){
			return (last + ", " + first + ": " + body + ". Active?: " + active);
		} else {
			return "Object Incomplete";
		}
	}
	
	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (first.length()==0) return false;
		if (last.length()==0) return false;
		Phone tempPhone = new Phone();
		tempPhone.setBody(body);
		tempPhone.setExtension(extension);
		if (!tempPhone.verify()) return false;
		if(!Skeletal.isEmail(email)) return false;
		return true;
	}

}
