package com.szss.factory;

import com.szss.model.Administrator;
import com.szss.model.People;
import com.szss.model.User;

public class PeopleFactory {
	public People findRole(User user){
		if(user.getRoleId()==0){
			return new Administrator(user);
		}
		return user;
	}
}
