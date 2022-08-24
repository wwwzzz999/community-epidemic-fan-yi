import com.smf.wqphd.bean.MaterialRequire;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.service.MaterialRequireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-core.xml")
public class MRServiceTest {

    @Autowired
    private MaterialRequireService materialRequireService;

    @Test
    public void testFindByPager(){
        Pager<MaterialRequire> pager =null;

        pager=new Pager<>(1,10);

        List<MaterialRequire> list= materialRequireService.findListByPager(pager);

        for (MaterialRequire user:list){
            System.out.println("   "+user);
        }

        int total= materialRequireService.findTotalByPager(pager);
        System.out.println("  "+total);
        System.out.println(Double.parseDouble("222"));
    }


    @Test
    public void testAdd(){

        MaterialRequire materialRequire=new MaterialRequire();
        materialRequire.setCreate_time(new Date());
        materialRequire.setUpdate_time(new Date());
        materialRequire.setA_id(8);
        materialRequire.setM_id(3);
        materialRequire.setA_id(82);
        System.out.println(materialRequire);
        Result result = new Result(Boolean.FALSE, "新增失败");
        try {
            System.out.println("新增信息如下："+materialRequire);
            Boolean ret = materialRequireService.add(materialRequire);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

}
