package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Student;
import com.service.sys.StuService;

/*
 * 学生信息管理
 * 
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StuService stuService;
	
	
	/**
	 * 学生管理跳转
	 * @param request
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		return "views/sys/stuList";
	}
	
	/**
	 * 学生数据
	 * @param request
	 * @param student
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/data")
	public Map<String, Object> data(HttpServletRequest request, Student student) throws UnsupportedEncodingException {
		
		List<Student> list = stuService.getListByPage(student);
		Long count = stuService.getCount(student);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", list);
		
		return map;
	}
	

	/**
	 * 添加学生
	 * @param request
	 */
	@RequestMapping(value = "/addStudent")
	public String addStudent(Student student, HttpServletRequest request, Model model) {
		model.addAttribute("linkType", "add");
		return "views/sys/stuForm";
	}
	
	/**
	 * 编辑学生
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/editStudent")
	public String editStudent(HttpServletRequest request, Model model) {
		
		Student stu = new Student();
		
		String stuID = request.getParameter("stuID");
		stu.setStuID(stuID);

		stu = stuService.get(stu);
		model.addAttribute("linkType", "edit");
		model.addAttribute("stu",stu);
		
		return "views/sys/stuForm";
	}
	
	
	/**
	 * 保存学生信息
	 * @param request
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) throws UnsupportedEncodingException {
		Student student = new Student();
		
		String stuID = request.getParameter("stuID");	
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");	
		String university = request.getParameter("university");
		String college = request.getParameter("college");
		String major = request.getParameter("major");
		String stuClass = request.getParameter("stuClass");
		String entryDate = request.getParameter("entryDate");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");
		
		student.setStuID(stuID);
		student.setName(name);
		student.setGender(gender);
		student.setUniversity(university);
		student.setCollege(college);
		student.setMajor(major);
		student.setStuClass(stuClass);
		student.setEntryDate(entryDate);
		student.setPhone(phone);
		
		try {
			if( type.equals("add") && stuService.dao.getIdNum(student)!=0) {
				return "1";
			}
			stuService.save(student);
			return "0";	
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}
	
	/**
	 * 验证学生身份
	 * @param request
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/verify")
	public String verify(HttpServletRequest request, Student student) {
		
		
		return "";
	}
	
	
	/**
	 * 删除学生
	 * @param request
	 * @param student
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,Student student) {
		String result = "1";
		try {
			stuService.delete(student.getStuID());
			result = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	

	
	
}
