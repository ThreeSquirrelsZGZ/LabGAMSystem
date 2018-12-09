package com.szss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szss.model.Message;

public interface MessageMapper {
	List<Message> getInMessages(@Param("receiverid") Integer receiverid);
	List<Message> getOutMessages(@Param("sendid") Integer sendid);
	void saveEntity(Message message);
	void deleteInEntity(Integer id);
	void deleteOutEntity(Integer id);
	Message getEntityById(@Param("id")  Integer id);
}
