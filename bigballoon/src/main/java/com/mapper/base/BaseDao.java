package com.mapper.base;

import java.util.List;

/**
 * DAO支持类实现
 * @param <T>
 */
public interface BaseDao<T> {
	
	
	 /**
     * 总数
     * @param comUser
     * @return
     */
    Long getCount(T entity);

    /**
     * 获取单条数据
     * @param comUser
     * @return
     */
    T get(T entity);
    
    /**
     * 分页查询
     * @param comUser
     * @return
     */
    List<T> getListByPage(T entity);
	
    /**
     * 某ID数量
     * @param comUser
     * @return
     */
    Long getIdNum(T entity);
    
    /**
	 * 获取所有
	 * @param user
	 * @return
	 */
	public List<T> getAllList(T entity);
	
	/**
	 * 新增
	 * @param comUser
	 */
	public void insert(T entity);
	
	/**
	 * 修改
	 * @param comUser
	 */
	public void update(T entity);
	public void updatePWD(T entity);
	
	/**
	 * 删除
	 * @param comUser
	 */
	public void delete(String id);
	
}