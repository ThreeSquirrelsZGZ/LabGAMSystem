package com.szss.alg;

public class CalWagesbyAmount extends CalWages{

	@Override
	public double cal(double amount, int projectNum) {
		
		return amount*100+projectNum*10;
	}
	
}
