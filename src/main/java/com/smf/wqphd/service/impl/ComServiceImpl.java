package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.Comm;
import com.smf.wqphd.dao.CommDao;
import com.smf.wqphd.bean.Mate;
import com.smf.wqphd.service.CommService;
import com.smf.wqphd.vo.AddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComServiceImpl extends DefaultServiceImpl<Comm> implements CommService {
    @Autowired
    CommDao dao;

    @Override
    public Comm selectBydr(String d_name, String r_name) {

        return dao.selectBydr(d_name,r_name);
    }

    public Mate selMqById(int a_id){
        return dao.selMqById(a_id);
    }

    @Override
    public List<AddVo> selectTotal() {
        return dao.selectTotal();
    }

}
