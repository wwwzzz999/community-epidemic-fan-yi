package com.smf.wqphd.controller;

import com.smf.wqphd.bean.Colpic;
import com.smf.wqphd.bean.Visdata;
import com.smf.wqphd.service.VisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/vis")
public class VisController {
    @Autowired
    VisService service;
    @RequestMapping("/getPic")
    @ResponseBody
    public List<Visdata> getpic(){

        return service.picdataList();
    }

    @RequestMapping("/getCol")
    @ResponseBody
    public List<Colpic> getCol(){
        return service.colList();
    }
}
