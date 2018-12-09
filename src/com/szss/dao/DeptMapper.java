package com.szss.dao;

import com.szss.model.Dept;
import java.util.List;

public interface DeptMapper {
	void saveEntity(Dept dept);
	
	List<Dept> searchEntity();
	
	void deleteEntity(Integer id);
	
	void updateEntity(Dept dept);
	
	Dept getEntityById(Integer id);
}