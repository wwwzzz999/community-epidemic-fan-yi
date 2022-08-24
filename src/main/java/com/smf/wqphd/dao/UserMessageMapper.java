package com.smf.wqphd.dao;

import com.smf.wqphd.bean.UserMessage;

/**
 * 1、表格操作的Mapper通过继承BaseMapper可以简化编码
 * 2、表格操作Mapper可以自定更多的方法
 * 3、oop知识：继承的目标是为了提高系统的扩展性，也可以重用父类的代码
 * 
 * @author netboy
 *
 */
public interface UserMessageMapper extends BaseMapper<UserMessage> {
	
	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public UserMessage login(UserMessage user);
}
