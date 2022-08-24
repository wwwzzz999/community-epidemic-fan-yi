package com.smf.wqphd.service;


import com.smf.wqphd.bean.Resident;

import java.util.List;

public interface ResidService extends BaseService<Resident>{
    List<Resident> selectById(int a_id);
}
