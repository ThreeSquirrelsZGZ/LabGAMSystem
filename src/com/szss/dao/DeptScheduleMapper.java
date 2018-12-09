package com.szss.dao;

import com.szss.model.DeptSchedule;
import java.util.List;

public interface DeptScheduleMapper {
	void saveEntity(DeptSchedule deptSchedule);
	
	List<DeptSchedule> searchEntity();
	
	void deleteEntity(Integer id);
	
	void updateEntity(DeptSchedule deptSchedule);
	
	DeptSchedule getEntityById(Integer id);
}