package com.FManSSC.model.owner;

import com.FManSSC.model.backbones.Person;
import com.FManSSC.model.backbones._Synopsis;
import com.FManSSC.model.backbones._Verifiable;

public class Owner extends Person implements _Owner, _Verifiable, _Synopsis {

	public Owner(){
		
	}
	
	public Owner(long id, String first, String last, String body, String extension, String email, Boolean active){
		setId(id);
		setIdSet(true);
		setFirst(first);
		setLast(last);
		setBody(body);
		setExtension(extension);
		setEmail(email);
		setActive(true);
	}
	
	@Override
	public String synopsis(){
		if (verify()){
			return "Owner: " + super.synopsis();
		} else {
			return "Object Incomplete";
		}
	}
	
	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		return true;
	}

}
