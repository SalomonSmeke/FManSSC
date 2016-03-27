package com.FManSSC.model.reservation;

import com.FManSSC.model.backbones.Time;

public class Reservation implements _Reservation {

	private long id;
	private boolean idSet = false;
	private long roomId;
	private boolean roomIdSet = false;
	private long customerId;
	private boolean customerIdSet = false;

	private short yearSt;
	private byte monthSt;
	private byte daySt;
	private byte hourSt;
	private byte minuteSt;
	private byte secondSt;

	private short yearEn;
	private byte monthEn;
	private byte dayEn;
	private byte hourEn;
	private byte minuteEn;
	private byte secondEn;

	private String description;

	private boolean cancelled = false;

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
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!roomIdSet) return false;
		if (!customerIdSet) return false;
		Time tempStart = new Time (yearSt,monthSt,daySt,hourSt,minuteSt,secondSt);
		if (!tempStart.verify()) return false;
		Time tempEnd = new Time (yearEn,monthEn,dayEn,hourEn,minuteEn,secondEn);
		if (!tempEnd.verify()) return false;
		int res = tempStart.compare(tempEnd);
		if (res == -1) return false;
		return true;
	}
}
