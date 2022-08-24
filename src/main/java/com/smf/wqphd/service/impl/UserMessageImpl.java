package com.smf.wqphd.service.impl;

import com.smf.wqphd.bean.UserMessage;
import com.smf.wqphd.dao.UserMessageMapper;
import com.smf.wqphd.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 一个类可以同时继承一个父类和实现多个接口；
 * java的继承是单继承，java类只能有一个父类；
 * 一个类实现一个接口，就要实现这个接口的所有方法
 * 
 * @Service表示把当前类托管给spring，这样spring才能把UserMessageMapper依赖注入进来
 * @Transactional(rollbackFor = Exception.class)由spring进行事务管理，没有错误则提交事务，有错误则回滚事务
 * 
 * @author lenovo
 *
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserMessageImpl extends DefaultServiceImpl<UserMessage> implements UserMessageService {
	/**
	 * 使用注解进行依赖注入
	 */
	@Autowired
	private UserMessageMapper userMessageMapper;

	public UserMessage login(UserMessage user) {
		
		return userMessageMapper.login(user);
	}


}
