package com.mapper.sys;

import java.util.List;

//import org.apache.ibatis.annotations.Param;

import com.mapper.base.BaseDao;
import com.model.sys.Menu;
//import com.model.sys.MenuTree;
//import com.model.sys.MenuTreeCheck;

public interface MenuMapper extends BaseDao<Menu>{

//	/**
//	 * 获取菜单
//	 * @param user
//	 * @return
//	 */
//	public MenuTree getTree(MenuTree menu);
	
	/**
	 * 获取菜单（菜单加载用）
	 * @param admin
	 * @return
	 */
	public List<Menu> getByPidM(Menu menu);
	
//	/**
//	 * 获取菜单
//	 * @param user
//	 * @return
//	 */
//	public List<Menu> getByPid(Menu menu);
	
//	/**
//	 * 获取菜单
//	 * @param user
//	 * @return
//	 */
//	public List<MenuTree> getByPidTree(MenuTree menu);
//	
//	/**
//	 * 获取菜单
//	 * @param user
//	 * @return
//	 */
//	public List<MenuTreeCheck> getByPidTreeCheck(@Param("id") String id);
	
	/**
	 * 获取所有菜单（加载菜单用）
	 * @param admin
	 * @return
	 */
	public List<Menu> getAllListM(Menu menu);
	
}
