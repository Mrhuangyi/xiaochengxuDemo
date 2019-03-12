package com.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Admin;
import com.model.sys.Staff;
import com.service.sys.AdminService;
import com.service.sys.StaffService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StaffService staffService;
	
	
	/**
	 * 修改密码跳转页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pwd")
	public String pwd(HttpServletRequest request, Model model) {
		//获取当前用户
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		admin = (Admin) adminService.get(admin);
		model.addAttribute("admin", admin);
		return "views/admin/password";
	}
	
	/**
	 * 个人信息跳转页面
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/personInfo")
	public String personInfo(HttpServletRequest request, Model model) {
		//获取当前用户
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		admin = adminService.get(admin);
		
		Staff stf = new Staff();
		stf.setStfID(admin.getAdmID());
		
		Staff staff =  staffService.get(stf);
	
		model.addAttribute("admin", admin);
		model.addAttribute("staff",staff);
		
		return "views/admin/personInfo";
	}
	
	/**
	 * 保存个人信息
	 * @param request
	 * @param staff
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
	public String saveInfo(HttpServletRequest request,Staff staff) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		String stfID = request.getParameter("stfID");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String title = request.getParameter("title");
		String phone = request.getParameter("phone");
		
		staff.setStfID(stfID);
		staff.setName(name);
		staff.setDepartment(department);
		staff.setTitle(title);
		staff.setPhone(phone);
		
		try {
			staffService.update(staff);
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		}
	}
	
	/**
	 * 保存密码
	 * @param request
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/savePwd", method = RequestMethod.POST)
	public String savePwd(HttpServletRequest request, Model model, String id,String pwd, String pwd1, String pwd2) throws UnsupportedEncodingException {
		//获取当前用户
		Admin admin = new Admin();
		admin.setAdm_id(id);;
		admin = (Admin) adminService.get(admin);
		try {
			if(admin.getPwd().equals(pwd)){
				if(pwd1.equals(pwd2)){
					admin.setPwd(pwd1);
					adminService.updatePWD(admin);
					return "0";
				}else{
					return "1";
				}
			}else{
				return "2";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		}
	}
	
	/**
	 * 保存头像
	 * @param request
	 */
	@RequestMapping(value = "/savePic")
	public void savePic(HttpServletRequest request) {
		
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		String src = request.getParameter("src");
		admin.setImg(src);
		
		adminService.update(admin);
	}

}
