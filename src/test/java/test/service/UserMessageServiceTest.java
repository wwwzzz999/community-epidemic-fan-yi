package test.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.UserMessage;
import com.smf.wqphd.service.UserMessageService;

/**
 * 加载spring+mybatis的运行环境
 * 针对service业务层进行单元测试
 * 
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/spring/spring-core.xml")
public class UserMessageServiceTest {
	@Autowired
	private UserMessageService userMessageService;
	/**
	 * 单元测试：一个测试单元测试的功能要尽可能小；一次测试可以执行多个测试单元(一个测试方法就是一个测试单元)
	 */
	@Test
	public void testFind() {
		 UserMessage condition = new UserMessage(null,"管", null, 
				 null, null, null, null);	 
		 Pager pager = new Pager<UserMessage>(1, 10, condition);
		 
		
	  List<UserMessage> list = 	userMessageService.findListByPager(pager);
	  for(UserMessage userMessage : list) {
		  System.out.println(userMessage);
	  }
	  
	System.out.println(new Date());
	  
	  Integer total = userMessageService.findTotalByPager(pager);
	  System.out.println("total ::::  "+total);
	  
	}
	
	/**
	 * 在进行测试时，为了测试方便有时需要模拟测试，会进行mock测试，
	 * 本例可以在需要回滚事务的测试中添加@Transactional注解，就可以回滚了
	 * 当需要把数据保持到数据库，则把@Transactional注释掉或删除掉就可以了
	 */
	@Test
	@Transactional
	public void testAdd() {
		UserMessage object = new UserMessage(null, "superuser4",
				  "马云", "123456", "1368888666", "1368888666@qq.com", new  Date());
		boolean ret = userMessageService.add(object);
		if(ret) {
			System.out.println("新增成功！");
		}else {
			System.out.println("新增失败！");
		}
	}
	@Test
	@Transactional
	public void testEdit() {
		UserMessage object = new UserMessage(10018, null,
				  "马小云", null, "1366668888", "1366668888@qq.com", new  Date());
		boolean ret = userMessageService.edit(object);
		if(ret) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
	}
	@Test
	@Transactional
	public void testDelete() {
		UserMessage object = new UserMessage(10018, null, null, null, null, null,null);
		boolean ret = userMessageService.delete(object);
		if(ret) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
		}
	}
	
	
	
}



