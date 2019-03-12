package com.mapper.sys;

import java.util.List;
import java.util.Map;

import com.mapper.base.BaseDao;
import com.model.sys.Student;


public interface StudentMapper extends BaseDao<Student>{
	
	// 各年级学生数量
	public List<Map<String,Object>> getCountByGrade();
}
