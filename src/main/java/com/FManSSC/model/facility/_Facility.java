package com.FManSSC.model.facility;

import com.FManSSC.model.backbones._Verifiable;

public interface _Facility extends _Verifiable {

	public long getId();
	public void setId(long id);
	public long getOwnerId();
	public void setOwnerId(long ownerId);
	public long getAddressId();
	public void setAddressId(long address);
	public String getBody();
	public void setBody(String body);
	public String getExtension();
	public void setExtension(String extension);
	public String getDescription();
	public void setDescription(String description);
	public void appendDescription(String description);
	public boolean isActive();
	public void setActive(boolean active);

}
