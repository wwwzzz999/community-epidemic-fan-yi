package com.smf.wqphd.service;



import com.smf.wqphd.bean.Emergency;
import com.smf.wqphd.bean.ePager;

import java.util.List;

public interface EmergencyService extends BaseService<Emergency> {

    public List<Emergency> findListByPagerSortByOrder(ePager<Emergency> pager);

    public int findTotalByPagerrSortByOrder(ePager<Emergency> pager);

}
