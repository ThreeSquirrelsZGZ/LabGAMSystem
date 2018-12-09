package com.szss.alg;

public class CalWagesbyProject extends CalWages{

	@Override
	public double cal(double amount, int projectNum) {
		
		return amount*10+projectNum*100;
	}
}
