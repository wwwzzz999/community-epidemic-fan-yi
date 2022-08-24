package com.smf.wqphd.controller;


import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.Resident;
import com.smf.wqphd.service.ResidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ResController {
    @Autowired
    ResidService service;

    @RequestMapping("/getResid")
    @ResponseBody
    public Pager<Resident> getResid(int a_id){
        Pager<Resident> res=new Pager<Resident>();
        List<Resident> reslist=service.selectById(a_id);
        res.setRows(reslist);
        return res;
    }
}
