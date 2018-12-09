package com.szss.alg;

public class HolidayStrategy {
	//int holidays[]={9,11,9,10,9,10,9,8,9,13,8,10};
	Holidays h;
	public double arrangeholidays(int year,int month,int state){
		if(state==1){
			h=new CriticalHolidays();
			
		}else{
			h=new NormalHolidays();
		}
		return h.arrangeholidays(year,month);
	}
}
