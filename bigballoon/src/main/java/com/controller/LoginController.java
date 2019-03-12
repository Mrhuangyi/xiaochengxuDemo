package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.base.AjaxResult;
import com.model.sys.Admin;
import com.model.sys.Staff;
import com.service.sys.AdminService;

/*
 * 登陆
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AdminService adminService;
	
	private static Logger log = Logger.getLogger(LoginController.class);
	
	/**
	 * 登录跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		log.info("进入到登录界面！");
		return "views/sys/login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param name
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login")
	public AjaxResult login(HttpServletRequest request,String name,String pwd) {
		log.info("用户名:"+name);
		log.info("密码:"+pwd);
		HttpSession session = request.getSession(true); 
		AjaxResult ajaxResult = new AjaxResult();
		
		Admin admin = new Admin();
		
		admin.setLoginName(name);
		
		List<Admin> admins = adminService.getAllList(admin);
		if(admins.size() > 0) {
			Admin a = admins.get(0);
			
			if(pwd.equals(a.getPwd())){
				//登录成功
				//将admin放入session
					session.setAttribute("admin", a);
					ajaxResult.setCode("0");
					ajaxResult.setMsg("登录成功");
			}else{
				//密码不正确
				ajaxResult.setCode("1");
				ajaxResult.setMsg("密码不正确");
			}
		}else{
			//用户不存在
			ajaxResult.setCode("2");
			ajaxResult.setMsg("用户不存在");
		}
		return ajaxResult;
	}
	
	/**
	 * 退出
	 * @param request
	 * @param name
	 * @param pwd
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("admin");
		return "views/sys/login";
	}
	
}
