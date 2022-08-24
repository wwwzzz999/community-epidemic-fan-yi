package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.PeopleManage;
import com.smf.wqphd.dao.PeopleManageMapper;
import com.smf.wqphd.service.PeopleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PeopleManageImpl extends DefaultServiceImpl<PeopleManage> implements PeopleManageService {

    @Autowired
    private PeopleManageMapper peopleManageMapper;




    @Override
    public List<PeopleManage> selectBystatus(String h_status) {
        return peopleManageMapper.selectBystatus(h_status);
    }
}
