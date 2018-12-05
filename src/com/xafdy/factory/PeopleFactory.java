package com.xafdy.factory;

import com.xafdy.model.Administrator;
import com.xafdy.model.People;
import com.xafdy.model.User;

public class PeopleFactory {
	public People findRole(User user){
		if(user.getRoleId()==0){
			return new Administrator(user);
		}
		return user;
	}
}
