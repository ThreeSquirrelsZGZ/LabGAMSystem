package com.xafdy.model;

import java.util.Date;

public class Project {
    private Integer id;
    private Integer state;
    private Integer userid;
    private String username;
    
    
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
    private String name;

    public Project() {
		super();
	}
    private Date startDate;
    private Date endDate;
    private Double budget;
    private String content;
    
    private String start;
    
    
	public Project(Integer id, Integer state, Integer userid, String username,
			String name, Date startDate, Date endDate, Double budget,
			String content, String start, String end) {
		super();
		this.id = id;
		this.state = state;
		this.userid = userid;
		this.username = username;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.content = content;
		this.start = start;
		this.end = end;
	}

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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double budget) {
        this.budget = budget;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}