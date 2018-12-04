package com.xafdy.model;

public abstract class People {
    private Integer id;
    
    private String genderName;
    
    public abstract String getGenderName();

	public abstract void setGenderName(String genderName);
	
	private String deptName;
	

	public abstract String getDeptName();

	public abstract void setDeptName(String deptName);
	
	private String projectName;
	
	
	public abstract String getProjectName();

	public abstract void setProjectName(String projectName);;
    private String account;
    
    private String nationalName;
    
    private String educationName;
    
    public abstract String getNationalName();

	public abstract void setNationalName(String nationalName);

	public abstract String getEducationName();

	public abstract void setEducationName(String educationName);

    private String password;

    private Double wages;

    private String number;

    private String name;

    private Integer deptId;

    private Integer roleId;

    private Integer gender;

    private String telphone;

    private String address;

    private String idCardNo;

    private Integer nationalId;

    private Integer educationId;

    private String institute;

    private String major;

    private Integer projectId;

    public abstract Integer getId();

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public abstract void setAccount(String account);

    public String getPassword() {
        return password;
    }

    public abstract void setPassword(String password);

    public abstract Double getWages();

    public abstract void setWages(Double wages);
    public abstract String getNumber();
    public abstract void setNumber(String number);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract Integer getDeptId();
    public abstract void setDeptId(Integer deptId);
    public abstract Integer getRoleId();
    public abstract void setRoleId(Integer roleId);
    public abstract Integer getGender();
    public abstract void setGender(Integer gender);
    public abstract String getTelphone();
    public abstract void setTelphone(String telphone);
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract String getIdCardNo();
    public abstract void setIdCardNo(String idCardNo);
    public abstract Integer getNationalId();
    public abstract void setNationalId(Integer nationalId);
    public abstract Integer getEducationId();
    public abstract void setEducationId(Integer educationId);
    public abstract String getInstitute();
    public abstract void setInstitute(String institute);
    public abstract String getMajor();
    public abstract void setMajor(String major);
    public abstract Integer getProjectId();
    public abstract void setProjectId(Integer projectId);
}