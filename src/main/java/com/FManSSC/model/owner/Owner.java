package com.FManSSC.model.owner;

import com.FManSSC.model.backbones.Person;

public class Owner extends Person implements _Owner {

	@Override
	public boolean verify(){
		if (!super.verify()) return false;
		return true;
	}

}
