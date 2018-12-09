package com.szss.alg;

public class CriticalHolidays extends Holidays{
	@Override
	public double arrangeholidays(int year ,int month) {
		return super.getDH(year, month)/2;
		
	}
}
