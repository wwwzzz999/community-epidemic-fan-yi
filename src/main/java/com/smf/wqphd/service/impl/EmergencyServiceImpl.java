package com.smf.wqphd.service.impl;


import com.smf.wqphd.bean.Emergency;
import com.smf.wqphd.bean.ePager;
import com.smf.wqphd.dao.EmergencyMapper;
import com.smf.wqphd.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmergencyServiceImpl extends DefaultServiceImpl<Emergency> implements EmergencyService {

    @Autowired
    EmergencyMapper emergencyMapper;

    @Override
    public List<Emergency> findListByPagerSortByOrder(ePager<Emergency> pager) {
        return emergencyMapper.findListByPagerSortByOrder(pager);
    }

    @Override
    public int findTotalByPagerrSortByOrder(ePager<Emergency> pager) {
        return emergencyMapper.findTotalByPagerrSortByOrder(pager);
    }


}
