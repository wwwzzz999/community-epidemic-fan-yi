package com.smf.wqphd.dao;

import java.util.List;

import com.smf.wqphd.bean.Pager;

/**
 * 定义一个数据库通用的数据访问接口,可以用于操作不同表 使用java泛型技术进行定义
 * 
 * @author lenovo
 *
 */
public interface BaseMapper<T> {

	/**
	 * 定义通用新增方法
	 * 
	 * @param object
	 * @return
	 */
	public boolean add(T object);

	/**
	 * 定义通用的修改方法
	 * 
	 * @param object
	 * @return
	 */
	public boolean edit(T object);

	/**
	 * 定义通用的删除方法
	 * 
	 * @param object
	 * @return
	 */
	public boolean delete(T object);

	/**
	 * 根据主键查询数据
	 * 
	 * @param object
	 * @return
	 */
	public T findById(T object);

	/**
	 * 带条件查询的分页查询方法
	 * 
	 * @param pager
	 * @return
	 */
	public List<T> findByPager(Pager<T> pager);
	
	/**
	 * 条件查询记录总数,根据这个参数进行分页控制 
	 * 
	 * @param pager
	 * @return
	 */
	public Integer findTotalByPager(Pager<T> pager);

}
