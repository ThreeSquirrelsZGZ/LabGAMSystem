package com.xafdy.dao;

import com.xafdy.model.Project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
	void saveEntity(Project project);
	
	List<Project> searchEntity();
	
	void deleteEntity(Integer id);
	
	void updateEntity(Project project);
	
	Project getEntityById(Integer id);

	void checkProject(Project project);

	List<Project> getProjectByUser(@Param("id") Integer id);
}