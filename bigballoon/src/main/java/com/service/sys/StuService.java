package com.service.sys;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.sys.StudentMapper;
import com.model.sys.Student;
import com.service.base.CrudService;


@Service
@Transactional
public class StuService extends CrudService<StudentMapper,Student>{
	
	
	/**
	 * 保存或者更新
	 * @param entity
	 */
	public void save(Student entity) {
		if( dao.getIdNum(entity) == 0 ){
			System.out.println("调用了insert方法");
			dao.insert(entity);
		}else{
			System.out.println("调用了update方法");
			dao.update(entity);
		}
	}
	
	/**
	 * 获取各个年级人数
	 * @param entity
	 */
	public List<Map<String,Object>> getCountByGrade(){
		return dao.getCountByGrade();
	}
	
	
}
