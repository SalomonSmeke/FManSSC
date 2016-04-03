package com.FManSSC.model.reservation;

import com.FManSSC.model.backbones.Time;
import com.FManSSC.model.customer.Customer;
import com.FManSSC.model.room.Room;

public class Reservation implements _Reservation {

	private long id;
	private boolean idSet = false;
	private Room room;
	private Customer customer;

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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public boolean isIdSet() {
		return idSet;
	}
	public void setIdSet(boolean idSet) {
		this.idSet = idSet;
	}
	public short getYearSt() {
		return yearSt;
	}
	public void setYearSt(short yearSt) {
		this.yearSt = yearSt;
	}
	public byte getMonthSt() {
		return monthSt;
	}
	public void setMonthSt(byte monthSt) {
		this.monthSt = monthSt;
	}
	public byte getDaySt() {
		return daySt;
	}
	public void setDaySt(byte daySt) {
		this.daySt = daySt;
	}
	public byte getHourSt() {
		return hourSt;
	}
	public void setHourSt(byte hourSt) {
		this.hourSt = hourSt;
	}
	public byte getMinuteSt() {
		return minuteSt;
	}
	public void setMinuteSt(byte minuteSt) {
		this.minuteSt = minuteSt;
	}
	public byte getSecondSt() {
		return secondSt;
	}
	public void setSecondSt(byte secondSt) {
		this.secondSt = secondSt;
	}
	public short getYearEn() {
		return yearEn;
	}
	public void setYearEn(short yearEn) {
		this.yearEn = yearEn;
	}
	public byte getMonthEn() {
		return monthEn;
	}
	public void setMonthEn(byte monthEn) {
		this.monthEn = monthEn;
	}
	public byte getDayEn() {
		return dayEn;
	}
	public void setDayEn(byte dayEn) {
		this.dayEn = dayEn;
	}
	public byte getHourEn() {
		return hourEn;
	}
	public void setHourEn(byte hourEn) {
		this.hourEn = hourEn;
	}
	public byte getMinuteEn() {
		return minuteEn;
	}
	public void setMinuteEn(byte minuteEn) {
		this.minuteEn = minuteEn;
	}
	public byte getSecondEn() {
		return secondEn;
	}
	public void setSecondEn(byte secondEn) {
		this.secondEn = secondEn;
	}
	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!room.verify()) return false;
		if (!customer.verify()) return false;
		Time tempStart = new Time (yearSt,monthSt,daySt,hourSt,minuteSt,secondSt);
		if (!tempStart.verify()) return false;
		Time tempEnd = new Time (yearEn,monthEn,dayEn,hourEn,minuteEn,secondEn);
		if (!tempEnd.verify()) return false;
		int res = tempStart.compare(tempEnd);
		if (res == -1) return false;
		return true;
	}
}
