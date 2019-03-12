package com.model.sys;

import com.model.page.PageDto;

public class Admin extends PageDto{
	String loginName;
	String pwd;
	String img;
	String admID;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAdmID() {
		return admID;
	}
	public void setAdm_id(String admID) {
		this.admID = admID;
	}
	
	
}
