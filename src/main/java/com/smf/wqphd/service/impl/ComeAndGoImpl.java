package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.ComeAndGo;
import com.smf.wqphd.dao.ComeAndGoMapper;
import com.smf.wqphd.service.ComeAndGoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComeAndGoImpl extends DefaultServiceImpl<ComeAndGo> implements ComeAndGoService {

    @Autowired
    private ComeAndGoMapper comeAndGoMapper;

    @Override
    public boolean deleteById(Integer o_id) {
        return comeAndGoMapper.deleteById(o_id);
    }
}
