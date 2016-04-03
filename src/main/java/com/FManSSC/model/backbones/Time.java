package com.FManSSC.model.backbones;

import com.FManSSC.dataHelpers.Numerical;

public class Time implements _Verifiable {

	private short year;
	private byte month;
	private byte day;
	private byte hour;
	private byte minute;
	private byte second;

	public Time(){

	}

	public Time(short year, byte month, byte day, byte hour, byte minute, byte second){
		this.year=year;
		this.month=month;
		this.day=day;
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}

	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public byte getMonth() {
		return month;
	}
	public void setMonth(byte month) {
		this.month = month;
	}
	public byte getDay() {
		return day;
	}
	public void setDay(byte day) {
		this.day = day;
	}
	public byte getHour() {
		return hour;
	}
	public void setHour(byte hour) {
		this.hour = hour;
	}
	public byte getMinute() {
		return minute;
	}
	public void setMinute(byte minute) {
		this.minute = minute;
	}
	public byte getSecond() {
		return second;
	}
	public void setSecond(byte second) {
		this.second = second;
	}

	@Override
	public boolean verify() {
		if (!Numerical.arePositive(year,month,day,hour,minute,second)) return false;
		if (month>12) return false;
		if (day>Numerical.daysInMonth(month,year)) return false;
		if (hour>23) return false;
		if (minute>59) return false;
		if (second>59) return false;
		return true;
	}

	public byte compare(Time comp){
		//1 gt 0 eq -1 lt
		if (comp.getYear() > year) return 1;
		if (comp.getYear() < year) return -1;
		if (comp.getMonth() > month) return 1;
		if (comp.getMonth() < month) return -1;
		if (comp.getDay() > day) return 1;
		if (comp.getDay() < day) return -1;
		if (comp.getHour() > hour) return 1;
		if (comp.getHour() < hour) return -1;
		if (comp.getMinute() > minute) return 1;
		if (comp.getMinute() < minute) return -1;
		if (comp.getSecond() > second) return 1;
		if (comp.getMonth() < second) return -1;
		return 0;
	}

}
