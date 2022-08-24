package com.smf.wqphd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.bean.UserMessage;
import com.smf.wqphd.service.UserMessageService;

@Controller
@RequestMapping("/usermessage")
public class UserMessageController {
	/**
	 * 控制层调用业务层完成业务计算
	 */
	@Autowired
	private UserMessageService userMessageService;

	/**
	 * @param page
	 * @param size easyui传递分页大小用的参数名是rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pager<UserMessage> findList(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "rows", defaultValue = "10") Integer size) {
		Pager<UserMessage> param = new Pager<UserMessage>(page, size);
		List<UserMessage> list = userMessageService.findListByPager(param);
		int total = userMessageService.findTotalByPager(param);
		// easyui的grid table解析数据时，json格式的名称叫rows
		param.setRows(list);
		param.setTotal(total);
		return param;
	}

	/**
	 * <pre>
	 *   在spring 控制器中获取用户输入有3种常用方法：
	 *     1.使用servlet技术获取，HttpServletRequest对象获取,只要把该对象注入到方法参数中即可
	 *     2.可以在方法中使用多参数进行获取，如参考findList方法
	 *     3.使用一个与参数列表对应的java类对象进行获取，spring会自动完成数据的接收，转换，和封装
	 *     
	 *     4.本方法是第三种接收
	 * 
	 * </pre>
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Result add(UserMessage user) {
		// 接收用户输入的管理员信息，并保存到数据库中
		Result result = new Result(Boolean.FALSE, "新增失败");
		try {
			Boolean ret = userMessageService.add(user);
			if (ret != null && ret) {
				result = new Result(Boolean.TRUE, "新增成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("edit")
	@ResponseBody
	public Result edit(UserMessage user) {
		// 接收用户输入的管理员信息，并保存到数据库中
		Result result = new Result(Boolean.FALSE, "修改失败");
		try {
			System.out.println(user);
			Boolean ret = userMessageService.edit(user);
			if (ret != null && ret) {
				System.out.println(user);
				result = new Result(Boolean.TRUE, "修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Result delete(UserMessage user) {
		// 接收用户输入的管理员信息，并保存到数据库中
		Result result = new Result(Boolean.FALSE, "删除失败");
		try {
			Boolean ret = userMessageService.delete(user);
			if (ret != null && ret) {
				result = new Result(Boolean.TRUE, "删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("login")
	@ResponseBody
	public Result login(UserMessage user, HttpSession session) {

		// 接收用户登录信息
		Result result = new Result(Boolean.FALSE, "登录失败");
		try {
			UserMessage userMessage = userMessageService.login(user);
			if (userMessage != null) {
				session.setAttribute("LOGIN_USER", userMessage);
				result = new Result(Boolean.TRUE, "登录成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping("logout")
	@ResponseBody
	public ModelAndView logout( HttpSession session) {
		ModelAndView view = new ModelAndView("redirect:/pages/index.html");
		session.invalidate();
		return view;
	}
}
