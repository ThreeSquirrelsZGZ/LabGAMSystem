package com.xafdy.dao;

import com.xafdy.model.Attendance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AttendanceMapper {
	void saveEntity(Attendance attendance);
	
	List<Attendance> searchEntity();
	List<Attendance> searchByUser(@Param("id") Integer id);
}