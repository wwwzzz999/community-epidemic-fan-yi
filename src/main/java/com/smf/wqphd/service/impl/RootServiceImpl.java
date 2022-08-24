package com.smf.wqphd.service.impl;

import com.smf.wqphd.bean.Root_user;
import com.smf.wqphd.dao.RootDao;
import com.smf.wqphd.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RootServiceImpl implements RootService {

    @Autowired
    RootDao dao;

    public List<Root_user> selectAll() {
        System.out.println("执行service");
        return dao.selectAll();
    }


    public Root_user selectByName(String name) {
        return dao.selectByName(name);
    }


    public boolean updateByName(String name, String password) {
        System.out.println("update执行");
        return dao.updateByName(name,password);
    }
}
