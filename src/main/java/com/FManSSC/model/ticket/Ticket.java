package com.FManSSC.model.ticket;

import com.FManSSC.model.backbones.Time;

public class Ticket implements _Ticket {

	private long id;
	private boolean idSet = false;
	private long roomId;
	private boolean roomIdSet = false;
	private long customerId;
	private boolean customerIdSet = false;

	private short yearOp;
	private byte monthOp;
	private byte dayOp;
	private byte hourOp;
	private byte minuteOp;
	private byte secondOp;

	private short yearCl;
	private byte monthCl;
	private byte dayCl;
	private byte hourCl;
	private byte minuteCl;
	private byte secondCl;

	private String description;

	private boolean open = true;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		idSet = true;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
		roomIdSet = true;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
		customerIdSet = true;
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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!roomIdSet) return false;
		if (!customerIdSet) return false;
		Time tempOpen = new Time (yearOp,monthOp,dayOp,hourOp,minuteOp,secondOp);
		if (!tempOpen.verify()) return false;
		Time tempClosed = new Time (yearCl,monthCl,dayCl,hourCl,minuteCl,secondCl);
		if (!tempClosed.verify()) return false;
		if (!open){
			int res = tempClosed.compare(tempOpen);
			if (res == 0 || res == 1) return false;
		}
		return true;
	}
}
