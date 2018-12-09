package com.szss.util;

public class HolidayProxy implements LegalHolidays{
	private LegalHolidays lh;
	public HolidayProxy(LegalHolidays lh){
		this.lh=lh;
	}
	public int getDetailHolidays(int year,int month){
		return lh.getDetailHolidays(year, month);
	}
}
