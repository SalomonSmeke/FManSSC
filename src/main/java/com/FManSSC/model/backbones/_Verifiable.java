package com.FManSSC.model.backbones;

public interface _Verifiable {

	default public boolean verify(){
		System.out.println("Not implemented for class");
		return false;
	}

}
