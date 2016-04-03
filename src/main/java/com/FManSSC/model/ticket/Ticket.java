package com.FManSSC.model.ticket;

import com.FManSSC.model.backbones.Time;
import com.FManSSC.model.customer.Customer;
import com.FManSSC.model.room.Room;

public class Ticket implements _Ticket {

	private long id;
	private boolean idSet = false;
	private Room room;
	private Customer customer;

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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public short getYearOp() {
		return yearOp;
	}
	public void setYearOp(short yearOp) {
		this.yearOp = yearOp;
	}
	public byte getMonthOp() {
		return monthOp;
	}
	public void setMonthOp(byte monthOp) {
		this.monthOp = monthOp;
	}
	public byte getDayOp() {
		return dayOp;
	}
	public void setDayOp(byte dayOp) {
		this.dayOp = dayOp;
	}
	public byte getHourOp() {
		return hourOp;
	}
	public void setHourOp(byte hourOp) {
		this.hourOp = hourOp;
	}
	public byte getMinuteOp() {
		return minuteOp;
	}
	public void setMinuteOp(byte minuteOp) {
		this.minuteOp = minuteOp;
	}
	public byte getSecondOp() {
		return secondOp;
	}
	public void setSecondOp(byte secondOp) {
		this.secondOp = secondOp;
	}
	public short getYearCl() {
		return yearCl;
	}
	public void setYearCl(short yearCl) {
		this.yearCl = yearCl;
	}
	public byte getMonthCl() {
		return monthCl;
	}
	public void setMonthCl(byte monthCl) {
		this.monthCl = monthCl;
	}
	public byte getDayCl() {
		return dayCl;
	}
	public void setDayCl(byte dayCl) {
		this.dayCl = dayCl;
	}
	public byte getHourCl() {
		return hourCl;
	}
	public void setHourCl(byte hourCl) {
		this.hourCl = hourCl;
	}
	public byte getMinuteCl() {
		return minuteCl;
	}
	public void setMinuteCl(byte minuteCl) {
		this.minuteCl = minuteCl;
	}
	public byte getSecondCl() {
		return secondCl;
	}
	public void setSecondCl(byte secondCl) {
		this.secondCl = secondCl;
	}
	@Override
	public boolean verify(){
		if (!idSet) return false;
		if (!room.verify()) return false;
		if (!customer.verify()) return false;
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
