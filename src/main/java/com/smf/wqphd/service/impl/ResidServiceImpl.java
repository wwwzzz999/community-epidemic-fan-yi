package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.Resident;
import com.smf.wqphd.dao.ResidDao;
import com.smf.wqphd.service.ResidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidServiceImpl extends DefaultServiceImpl<Resident> implements ResidService {
    @Autowired
    ResidDao dao;
    public List<Resident> selectById(int a_id){
        return dao.selectById(a_id);
    };
}
