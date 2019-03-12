package com.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Book;
import com.model.sys.Staff;
import com.model.sys.Student;
import com.service.sys.BookService;
import com.service.sys.StaffService;
import com.service.sys.StuService;

import net.sf.json.JSONObject;

/**
 * 首页
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	private static Logger log = Logger.getLogger(IndexController.class);

	@Autowired
	StuService stuService;
	@Autowired
	StaffService staffService;	
	@Autowired
	BookService bookService;
	
	/**
	 * 后台主页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model) {
		log.info("转到首页！");
		return "views/sys/index";
	}
	
	/**
	 * 后台主页面（默认页）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("main")
	public String main(HttpServletRequest request, Model model,Student student,Staff staff,Book book) {
		long stuNo = stuService.getCount(student);
		long grd16 = (Long)stuService.getCountByGrade().get(0).get("num");
		long grd17 = (Long)stuService.getCountByGrade().get(1).get("num");
		long grd18 = (Long)stuService.getCountByGrade().get(2).get("num");
		long staffNo = staffService.getCount(staff); 
		long bookNo = bookService.getCount(book);

		Map<String, Object> InfoMap = new HashMap<String,Object>();
		InfoMap.put("stuNo", stuNo);
		InfoMap.put("staffNo", staffNo);
		InfoMap.put("bookNo", bookNo);
		InfoMap.put("grd16No", grd16);
		InfoMap.put("grd17No", grd17);
		InfoMap.put("grd18No", grd18);
		
		// 把 Map -> JsonString 有利于前端显示
		JSONObject jsonMap = JSONObject.fromObject(InfoMap);
		model.addAttribute("InfoMap",jsonMap);
		System.out.println("jsonMap: " + jsonMap);
		return "views/sys/main";
	}
	


}
