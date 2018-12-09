package com.szss.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class DeptSchedule {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date endDate;
    private String position;
    private Integer deptId;
    private String content;
    
    private String deptName;
    
    private String start;
    
    private String end;
    
    
    
    public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}