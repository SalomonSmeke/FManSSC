package com.FManSSC.model.backbones;

import com.FManSSC.dataHelpers.Numerical;

public class Phone implements _Verifiable {

	private String body = "";
	private String extension = "";

	public Phone(){
		extension = "";
	}
	
	public Phone(String body, String extension){
		this.extension = extension;
		this.body = body;
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

	@Override
	public boolean verify() {
		if (!Numerical.isNumerical(body)) return false;
		if (body.length()>15 || body.length()<10) return false; //http://stackoverflow.com/questions/723587/whats-the-longest-possible-worldwide-phone-number-i-should-consider-in-sql-varc

		if (!Numerical.isNumerical(extension)) return false;
		if (extension.length()>11) return false; //same source

		return true;
	}

}
