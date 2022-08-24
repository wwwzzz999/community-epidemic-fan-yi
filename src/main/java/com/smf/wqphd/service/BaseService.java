package com.smf.wqphd.service;

import java.util.List;

import com.smf.wqphd.bean.Pager;

/**
 * 
 * @author netboy
 *
 * @param <T> 业务层通用CRUD操作方法封装，Result类用于easyUI更新操作用
 */
public interface BaseService<T> {
	
	/**
	 * 使用泛型定义的通用带条件分页查询方法
	 * @param pager
	 * @return
	 */
	public List<T> findListByPager(Pager<T> pager);

	/**
	 * 使用泛型定义的通用带条件记录数方法
	 * @param pager
	 * @return
	 */
	public Integer findTotalByPager(Pager<T> pager);

	/**
	 * 使用泛型定义的通用新增操作方法
	 * @param object
	 * @return
	 */
	public boolean add(T object);

	/**
	 * 使用泛型定义的通用修改操作方法
	 * @param object
	 * @return
	 */
	public boolean edit(T object);

	/**
	 * 使用泛型定义的通用删除操作方法
	 * @param ids
	 * @return
	 */
	public boolean delete(T id);
}