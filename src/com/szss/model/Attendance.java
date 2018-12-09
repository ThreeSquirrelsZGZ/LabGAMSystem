package com.szss.model;

import java.util.Date;

public class Attendance{
    private Integer id;

    private Integer userId;

    private Date recordDate;

    private Double amount;

    private Double leave;

    private Double absenteeism;

    private Double vacation;

    private Double realAmount;
    
    private String userName;
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getLeave() {
        return leave;
    }

    public void setLeave(Double leave) {
        this.leave = leave;
    }

    public Double getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(Double absenteeism) {
        this.absenteeism = absenteeism;
    }

    public Double getVacation() {
        return vacation;
    }

    public void setVacation(Double vacation) {
        this.vacation = vacation;
    }

    public Double getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Double realAmount) {
        this.realAmount = realAmount;
    }
}