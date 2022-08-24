import com.smf.wqphd.bean.PeopleManage;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.service.PeopleManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-core.xml")
public class PMServiceTest {

    @Autowired
    private PeopleManageService peopleManageService;

    @Test
    public void testFindByPager(){
        Pager<PeopleManage> pager =null;

        pager=new Pager<>(1,10);

        List<PeopleManage> list= peopleManageService.findListByPager(pager);

        for (PeopleManage user:list){
            System.out.println("   "+user);
        }

        int total= peopleManageService.findTotalByPager(pager);
        System.out.println("  "+total);
        System.out.println(Double.parseDouble("222"));
    }

    @Test
    public void testAdd(){

        PeopleManage peopleManage=new PeopleManage();
        peopleManage.setCreate_time(new Date());
        peopleManage.setUpdate_time(new Date());
        peopleManage.setP_card("1321321");
        peopleManage.setA_id(95);
        peopleManage.setP_email("jhh@qq.com");
        peopleManage.setP_name("soIU和爱好反馈近距离靠的就是");
        System.out.println(peopleManage);
        Result result = new Result(Boolean.FALSE, "新增失败");
        try {
            System.out.println("新增信息如下："+peopleManage);
            Boolean ret = peopleManageService.add(peopleManage);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }
}
