package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.Colpic;
import com.smf.wqphd.bean.Visdata;
import com.smf.wqphd.dao.visDao;
import com.smf.wqphd.service.VisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisServiceImpl implements VisService {
    @Autowired
    visDao dao;
    @Override
    public List<Visdata> picdataList() {
        return dao.picdataList();
    }

    @Override
    public List<Colpic> colList() {
        return dao.colList();
    }
}
