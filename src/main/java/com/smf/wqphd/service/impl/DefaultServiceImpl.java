package com.smf.wqphd.service.impl;

import java.util.List;

import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.dao.BaseMapper;
import com.smf.wqphd.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 默认业务实现类，提供默认的实现方法 ; 其它业务功能都需要继承该类进行功能编写！
 * 
 * @author netboy
 *
 * @param <T>
 */

public abstract class DefaultServiceImpl<T> implements BaseService<T> {
	
	/**
	 * 使用了spring的另外一种依赖注入的方法： 注解方法 ;
	 * @Autowired 表示自动注入，不需要构造方法或set方法就可以实现依赖注入 
	 * 使用注解方式进行配置的目的是为了提高代码的可维护性
	 */
	@Autowired
	private BaseMapper<T> baseMapper;

	public List<T> findListByPager(Pager<T> pager) {

		return baseMapper.findByPager(pager);
	}

	public Integer findTotalByPager(Pager<T> pager) {

		return baseMapper.findTotalByPager(pager);
	}

	public boolean add(T object) {

		return baseMapper.add(object);
	}

	public boolean edit(T object) {

		return baseMapper.edit(object);
	}

	public boolean delete(T id) {

		return baseMapper.delete(id);
	}

}