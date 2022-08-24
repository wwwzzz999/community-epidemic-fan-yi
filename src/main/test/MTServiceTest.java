import com.smf.wqphd.bean.MaterialType;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.service.MaterialTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-core.xml")
public class MTServiceTest {

    @Autowired
    private MaterialTypeService materialTypeService;

    @Test
    public void testFindByPager(){
        Pager<MaterialType> pager =null;

        pager=new Pager<>(1,10);

        List<MaterialType> list= materialTypeService.findListByPager(pager);

        for (MaterialType user:list){
            System.out.println("   "+user);
        }

        int total= materialTypeService.findTotalByPager(pager);
        System.out.println("  "+total);
        System.out.println(Double.parseDouble("222"));
    }


    @Test
    public void testAdd(){

        MaterialType materialType=new MaterialType();
        materialType.setCreate_time(new Date());
        materialType.setUpdate_time(new Date());
        materialType.setM_name("siuivakjvnma");
        materialType.setM_desc("kuksaicjksajkslasdsadsa");
        System.out.println(materialType);
        Result result = new Result(Boolean.FALSE, "新增失败");
        try {
            System.out.println("新增信息如下："+materialType);
            Boolean ret = materialTypeService.add(materialType);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }


}
