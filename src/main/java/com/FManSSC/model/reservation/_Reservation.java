package com.FManSSC.model.reservation;

import com.FManSSC.model.backbones._Verifiable;

public interface _Reservation extends _Verifiable {

	public long getId();
	public void setId(long id);
	public long getRoomId();
	public void setRoomId(long roomId);
	public long getCustomerId();
	public void setCustomerId(long customerId);
	public String getDescription();
	public void setDescription(String description);
	public void appendDescription(String description);
	public boolean isCancelled();
	public void setCancelled(boolean cancelled);

}
