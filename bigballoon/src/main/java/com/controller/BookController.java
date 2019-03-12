package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.sys.Book;
import com.service.sys.BookService;



@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 根据书名查找
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/lookByName")
	public Map<String, Object> lookByName(HttpServletRequest request, Book book) {
		System.out.println("进入到lookByName函数");
		
		String name = request.getParameter("name");
		book.setName(name);
		
		Book result = bookService.get(book);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("author", result.getAuthor());
		map.put("press", result.getPress());
		map.put("sort", result.getSort());
		map.put("location", result.getLocation());
		map.put("imgUrl", result.getImg());
		map.put("synopsis", result.getSynopsis());
		
		return map;
	}
	
	

}
