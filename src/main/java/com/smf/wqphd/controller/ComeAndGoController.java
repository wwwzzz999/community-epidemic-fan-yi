package com.smf.wqphd.controller;


import com.smf.wqphd.bean.ComeAndGo;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Result;
import com.smf.wqphd.service.ComeAndGoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("comeandgo")
public class ComeAndGoController {

    @Autowired
    private ComeAndGoService comeAndGoService;

    @RequestMapping("comeandgolist")
    @ResponseBody
    public Pager<ComeAndGo> comeandgolist(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                          @RequestParam(name = "rows", defaultValue = "10") Integer size) {

        Pager<ComeAndGo> pager = new Pager<>(page, 20);
        // 按查询条件进行分页查询
        List<ComeAndGo> comeandgoList = comeAndGoService.findListByPager(pager);

        Integer total = comeAndGoService.findTotalByPager(pager);

        pager.setRows(comeandgoList);
        pager.setTotal(total);

        return pager;
    }

    @RequestMapping("add")
    @ResponseBody
    public Result doAdd(ComeAndGo comeAndGo) {

        comeAndGo.setO_gtime(new Date());
        comeAndGo.setCreate_time(new Date());
        Result result = new Result(Boolean.FALSE, "登记失败!");
        try {
            boolean res = comeAndGoService.add(comeAndGo);
            if (res) {
                result = new Result(Boolean.TRUE, "登记成功!");
            }
        } catch (Exception e) {

        }
        return result;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Result doEdit(ComeAndGo comeAndGo) {
        comeAndGo.setO_btime(new Date());
        comeAndGo.setUpdate_time(new Date());
        Result result = new Result(Boolean.FALSE, "登记失败!");

        try {
            System.out.println(comeAndGo);
            boolean res = comeAndGoService.edit(comeAndGo);
            if (res) {
                result = new Result(Boolean.TRUE, "登记成功!");
            }
        } catch (Exception e) {
        }
        return result;
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteOne(Integer o_id) {
        Result result = new Result(Boolean.FALSE, "删除失败!");

        try {
            boolean res = comeAndGoService.deleteById(o_id);
            if (res) {
                result = new Result(Boolean.TRUE, "删除成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
