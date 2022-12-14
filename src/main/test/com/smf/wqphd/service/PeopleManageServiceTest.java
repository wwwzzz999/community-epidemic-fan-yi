package com.smf.wqphd.service;

import com.smf.wqphd.bean.PeopleManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/spring/spring-core.xml")
public class PeopleManageServiceTest {
    @Autowired
    PeopleManageService peopleManageService;

    @Test
    public void selectBystatus() {
        List<PeopleManage> list = peopleManageService.selectBystatus("绿码");
        for (PeopleManage peopleManage : list) {
            System.out.println(peopleManage);
        }
    }
}