package com.szss.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.szss.model.User;


public interface UserMapper {
	void saveEntity(User user);
	
	List<User> searchEntity();
	List<User> searchMessageEntity(@Param("userid") Integer userid);
	
	void deleteEntity(Integer id);
	
	void updateEntity(User user);
	
	User getEntityById(Integer id);
	
	User userLogon(Map<String, Object> map);
	
}