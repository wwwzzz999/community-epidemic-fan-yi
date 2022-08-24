package test.service;


import com.smf.wqphd.bean.Emergency;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.service.EmergencyService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/spring/spring-core.xml")
public class EmergencyServiceImplTest extends TestCase {

    @Autowired
    EmergencyService emergencyService;

    //查询
    @Test
    public void query() {
        Emergency emergency1 = new Emergency();
        emergency1.seteDetail("广东");
        Pager pager = new Pager<Emergency>(1, 10, null);
        List<Emergency> listByPager = emergencyService.findListByPager(pager);
        for (Emergency emergency : listByPager) {
            System.out.println(emergency);
        }
    }

    //添加
    @Test
    public void add() {
        Emergency emergency = new Emergency();
        emergency.seteName("国服孙尚香");
        emergency.seteDetail("xxx花了1一个月时间再次打上国服...");
        emergency.setCreateTime(new Date());
        emergency.setUpdateTime(new Date());
        System.out.println(emergencyService.add(emergency));
    }

    //修改
    @Test
    public void edit() {
        Emergency emergency = new Emergency();
        emergency.seteId(5);
        emergency.seteName("国服孙策");
        emergency.seteDetail("xxx花了1一个月时间再次打上国服...");
        emergency.setUpdateTime(new Date());
        System.out.println(emergencyService.edit(emergency));
    }

    //删除
    @Test
    public void delete() {
        Emergency emergency = new Emergency();
        emergency.seteId(6);
        System.out.println(emergencyService.delete(emergency));
    }
}