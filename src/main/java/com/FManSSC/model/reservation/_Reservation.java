package com.FManSSC.model.reservation;

import com.FManSSC.model.backbones._Verifiable;
import com.FManSSC.model.customer.Customer;
import com.FManSSC.model.room.Room;

public interface _Reservation extends _Verifiable {

	public long getId();
	public void setId(long id);
	public Room getRoom();
	public void setRoom(Room room);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public String getDescription();
	public void setDescription(String description);
	public void appendDescription(String description);
	public boolean isCancelled();
	public void setCancelled(boolean cancelled);

}
