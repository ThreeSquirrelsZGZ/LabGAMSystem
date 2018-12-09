package com.szss.model;

public class User extends People{
    private Integer id;
    
    private String genderName;
    
    public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	
	private String deptName;
	

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	private String projectName;
	
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
    private String account;
    
    private String nationalName;
    
    private String educationName;
    
    public String getNationalName() {
		return nationalName;
	}

	public void setNationalName(String nationalName) {
		this.nationalName = nationalName;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Double getWages() {
        return wages;
    }
    public void setWages(Double wages) {
        this.wages = wages;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getTelphone() {
        return telphone;
    }
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getIdCardNo() {
        return idCardNo;
    }
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
    public Integer getNationalId() {
        return nationalId;
    }
    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }
    public Integer getEducationId() {
        return educationId;
    }
    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }
    public String getInstitute() {
        return institute;
    }
    public void setInstitute(String institute) {
        this.institute = institute;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}