package com.smf.wqphd.controller;

import com.smf.wqphd.bean.MaterialRequire;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.service.MaterialRequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("mq")
public class MaterialRequireController {

    @Autowired
    private MaterialRequireService materialRequireService;

    @RequestMapping("list")
    @ResponseBody
    public Pager<MaterialRequire> list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        Pager<MaterialRequire> pager=new Pager<MaterialRequire>(page,rows);

        //用户数据
        List<MaterialRequire> list= materialRequireService.findListByPager(pager);
        //数据的总数
        int total= materialRequireService.findTotalByPager(pager);

        //把查询到的数据返回给前端
        pager.setTotal(total);
        pager.setRows(list);

        return pager;
    }



    @RequestMapping("add")
    @ResponseBody
    public Result add(MaterialRequire materialRequire) {

        materialRequire.setCreate_time(new Date());
        materialRequire.setUpdate_time(new Date());
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
        return result;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result edit(MaterialRequire materialRequire) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "修改失败");
        try {
            materialRequire.setUpdate_time(new Date());
            System.out.println("修改信息如下："+materialRequire);
            Boolean ret = materialRequireService.edit(materialRequire);
            if (ret != null && ret) {
                System.out.println(materialRequire);
                result = new Result(Boolean.TRUE, "修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(MaterialRequire materialRequire) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "删除失败");
        try {
            Boolean ret = materialRequireService.delete(materialRequire);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
