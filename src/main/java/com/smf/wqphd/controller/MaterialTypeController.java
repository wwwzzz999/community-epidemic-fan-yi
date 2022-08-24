package com.smf.wqphd.controller;


import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.bean.MaterialType;
import com.smf.wqphd.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("mt")
public class MaterialTypeController {

    @Autowired
    private MaterialTypeService materialTypeService;

    @RequestMapping("list")
    @ResponseBody
    public Pager<MaterialType> list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        Pager<MaterialType> pager=new Pager<MaterialType>(page,rows);

        //用户数据
        List<MaterialType> list= materialTypeService.findListByPager(pager);
        //数据的总数
        int total= materialTypeService.findTotalByPager(pager);

        //把查询到的数据返回给前端
        pager.setTotal(total);
        pager.setRows(list);

        return pager;
    }



    @RequestMapping("add")
    @ResponseBody
    public Result add(MaterialType materialType) {

        materialType.setCreate_time(new Date());
        materialType.setUpdate_time(new Date());
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
        return result;
    }


    @RequestMapping("edit")
    @ResponseBody
    public Result edit(MaterialType materialType) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "修改失败");
        try {
            materialType.setUpdate_time(new Date());
            System.out.println("修改信息如下："+materialType);
            Boolean ret = materialTypeService.edit(materialType);
            if (ret != null && ret) {
                System.out.println(materialType);
                result = new Result(Boolean.TRUE, "修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("delete")
    @ResponseBody
    public Result delete(MaterialType materialType) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "删除失败");
        try {
            Boolean ret = materialTypeService.delete(materialType);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/typelist")
    @ResponseBody
    public List<MaterialType> r() {
        return materialTypeService.selectTotal();
    }

}
