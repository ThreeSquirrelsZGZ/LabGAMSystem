package com.xafdy.alg;

import com.xafdy.util.DetailHolidays;
import com.xafdy.util.HolidayProxy;

public abstract class Holidays {
	int holiday;
	public int getDH(int year ,int month){
		
		//proxy 代理模式
		DetailHolidays dh=new DetailHolidays();
		HolidayProxy hp=new HolidayProxy(dh);
		return hp.getDetailHolidays(year, month);
		
	}
	public abstract double arrangeholidays(int year ,int month);
}
