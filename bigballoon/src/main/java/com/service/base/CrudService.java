/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.base.BaseDao;
import com.model.page.PageDto;

/**
 * Service基类
 * @author jeeplus
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends BaseDao<T>, T extends PageDto> {
	
	@Autowired
	public D dao;

	/**
	 * 获取总数
	 * @param entity
	 * @return
	 */
	public Long getCount(T entity) {
		return dao.getCount(entity);
	}
	
	/**
	 * 分页获取
	 * @param entity
	 * @return
	 */
	public List<T> getListByPage(T entity) {
		return dao.getListByPage(entity);
	}
	
	/**
	 * 获取某ID数量
	 * @param entity
	 * @return
	 */
	public Long getIdNum(T entity) {
		return dao.getIdNum(entity);
	}
	
	/**
	 * 获取所有
	 * @param entity
	 * @return
	 */
	public List<T> getAllList(T entity) {
		return dao.getAllList(entity);
	}
	
	/**
	 * 插入
	 * @param entity
	 */
	public void insert(T entity) {
		dao.insert(entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity) {
		dao.update(entity);
	}
	
	
	/**
	 * 更新密码
	 * @param entity
	 */
	public void updatePWD(T entity) {
		dao.updatePWD(entity);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id) {
		dao.delete(id);
	}
	
	
	/**
	 * 获取单个
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
}
