package com.smf.wqphd.dao;


import com.smf.wqphd.bean.Emergency;
import com.smf.wqphd.bean.ePager;

import java.util.List;

public interface EmergencyMapper extends BaseMapper<Emergency>{

    public List<Emergency> findListByPagerSortByOrder(ePager<Emergency> pager);

    public int findTotalByPagerrSortByOrder(ePager<Emergency> pager);
}
