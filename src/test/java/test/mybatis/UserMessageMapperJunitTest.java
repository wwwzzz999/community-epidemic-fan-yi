package test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.UserMessage;
import com.smf.wqphd.dao.UserMessageMapper;

public class UserMessageMapperJunitTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() {
		// 1.初始化mybatis运行环境
		try {
			String resource = "config/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFind() {		
		//SqlSession类似于jdbc的Connection连接 ,是对Connection连接的封装 
		 SqlSession session =  sqlSessionFactory.openSession();
		//2.使用session对象调用接口方法执行sql
		 UserMessageMapper mapper = session.getMapper(UserMessageMapper.class);
		 
		 UserMessage condition = new UserMessage(null,"管", null, 
				 null, null, null, null);	 
		 Pager pager = new Pager<UserMessage>(1, 10, condition);
		List<UserMessage> list=  mapper.findByPager(pager);	
		//3.根据sql执行结果进行数据处理 
		for(UserMessage userMessage : list) {
			System.out.println(userMessage);
		}	
	}

	@Test
	public void testAdd() {
		SqlSession session =  sqlSessionFactory.openSession();
		UserMessageMapper mapper = session.getMapper(UserMessageMapper.class);
		
		UserMessage object = new UserMessage(null, "superuser2",
				  "马云", "123456", "1368888666", "1368888666@qq.com", new  Date());
		boolean ret = mapper.add(object);
		if(ret) {
			System.out.println("新增成功！");
		}else {
			System.out.println("新增失败！");
		}
		//mybatis默认不提交事务，需要编码提交事务
		//成功验证事务后，在测试代码中建议关闭事务,方便测试
		//session.commit();	
	}
	
    @Test
	public void testEdit() {
		SqlSession session =  sqlSessionFactory.openSession();
		UserMessageMapper mapper = session.getMapper(UserMessageMapper.class);
		
		UserMessage object = new UserMessage(10018, null,
				  "马小云", null, "1366668888", "1366668888@qq.com", new  Date());
		boolean ret = mapper.edit(object);
		if(ret) {
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
		//成功验证事务后，在测试代码中建议关闭事务,方便测试
		session.commit();	
	}

    @Test
	public void testDelete() {
		SqlSession session =  sqlSessionFactory.openSession();
		UserMessageMapper mapper = session.getMapper(UserMessageMapper.class);
		
		UserMessage object = new UserMessage(10018, null, null, null, null, null,null);
		boolean ret = mapper.delete(object);
		if(ret) {
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
		}
		//成功验证事务后，在测试代码中建议关闭事务,方便测试
		//session.commit();	
	}

}
