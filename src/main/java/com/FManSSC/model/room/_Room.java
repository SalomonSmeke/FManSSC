package com.FManSSC.model.room;

import com.FManSSC.model.backbones._Verifiable;
import com.FManSSC.model.facility.Facility;

public interface _Room extends _Verifiable {

	public long getId();
	public void setId(long id);
	public Facility getFacility();
	public void setFacility(Facility facility);
	public int getCapacity();
	public void setCapacity(int capacity);
	public double getCostPerHr();
	public void setCostPerHr(double costPerHr);
	public String getNumber();
	public void setNumber(String number);
	public String getLocation();
	public void setLocation(String location);
	public String getDescription();
	public void setDescription(String description);
	public void appendDescription(String description);
	public boolean isActive();
	public void setActive(boolean active);

}
