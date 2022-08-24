package com.smf.wqphd.controller;


import com.smf.wqphd.bean.Emergency;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.bean.ePager;
import com.smf.wqphd.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;

    @RequestMapping("/list")
    @ResponseBody
    public ePager<Emergency> findList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                      @RequestParam(name = "rows", defaultValue = "15") Integer size,
                                      @RequestParam(name = "sort", defaultValue = "createTime") String sort, @RequestParam(name = "order", defaultValue = "desc") String ord,
                                      Date fromDate, Date toDate, Emergency emergency) {
        ePager<Emergency> eparam = new ePager<Emergency>(page, size, emergency, sort, ord, fromDate, toDate);
        List<Emergency> list = emergencyService.findListByPagerSortByOrder(eparam);
        int total = emergencyService.findTotalByPagerrSortByOrder(eparam);
        // easyui的grid table解析数据时，json格式的名称叫rows
        eparam.setRows(list);
        eparam.setTotal(total);
        return eparam;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Emergency emergency) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "新增失败");
        try {
            emergency.setUpdateTime(new Date());
            emergency.setCreateTime(new Date());
            Boolean ret = emergencyService.add(emergency);
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
    public Result edit(Emergency emergency) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "修改失败");
        try {
            emergency.setUpdateTime(new Date());
            Boolean ret = emergencyService.edit(emergency);
            if (ret != null && ret) {
                System.out.println(emergency);
                result = new Result(Boolean.TRUE, "修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Emergency emergency) {
        // 接收用户输入的管理员信息，并保存到数据库中
        Result result = new Result(Boolean.FALSE, "删除失败");
        try {
            Boolean ret = emergencyService.delete(emergency);
            if (ret != null && ret) {
                result = new Result(Boolean.TRUE, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
