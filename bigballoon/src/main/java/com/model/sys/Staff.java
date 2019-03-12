package com.model.sys;

import com.model.page.PageDto;

public class Staff extends PageDto{
	String stfID;
	String name;
	String gender;
	String department;
	String title;
	String jobDate;
	String phone;
	
	public String getStfID() {
		return stfID;
	}
	public void setStfID(String stfID) {
		this.stfID = stfID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJobDate() {
		return jobDate;
	}
	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
