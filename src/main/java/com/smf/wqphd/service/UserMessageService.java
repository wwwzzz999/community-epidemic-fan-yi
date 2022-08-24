package com.smf.wqphd.service;

import com.smf.wqphd.bean.UserMessage;

/**
 * 
 * @author netboy
 *
 */
public interface UserMessageService extends BaseService<UserMessage>{
	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public UserMessage login(UserMessage user);
}
