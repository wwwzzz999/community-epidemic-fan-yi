package com.smf.wqphd.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <pre>
 * 1.编写一个类，类名与数据库表名对应，
 * 2.类的属性与数据库表的字段对应:名称与数据类型都需要对应
 * 3.编写对应的构造器和toString方法
 *
 * </pre>
 * @author lenovo
 */
public class UserMessage {
	/**
	 * 对于数值类和布尔类，建议使用包装类
	 */
	private Integer userNo;
	private String userName;
	private String nickName;
	private String password;
	private String userPhone;
	private String userEmail;
	
	/**
	 * 配置json数据的时间格式,yyyy-MM-dd  hh:mm:ss.SSS
	 * 
	 * 1.接收数据时，spring mvc默认接收的时间的格式：
	 *    yyyy/MM/dd  hh:mm:ss 或 yyyy/MM/dd  hh:mm:ss  或 Fri Jun 19 11:31:08 CST 2020
	 * 2.如果用户输入的时间格式与默认的不匹配，则需要编写一个时间转换器组件;自定义时间格式
	 * 3.或可以在数据接收的类中使用@DateTimeFormat(pattern = "yyyy-MM-dd" )指点用户输入的时间格式
	 * 
	 */
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd" )
	private Date userDate;
	
	
	public UserMessage() {
		super();
	}

	public UserMessage(Integer userNo, String userName, String nickName, String password, String userPhone,
			String userEmail, Date userDate) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userDate = userDate;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	@Override
	public String toString() {
		return "UserMessage [userNo=" + userNo + ", userName=" + userName + ", nickName=" + nickName + ", password="
				+ password + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", userDate=" + userDate + "]";
	}

	
}
