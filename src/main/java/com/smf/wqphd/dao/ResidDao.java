package com.smf.wqphd.dao;


import com.smf.wqphd.bean.Resident;

import java.util.List;

public interface ResidDao extends BaseMapper<Resident>{
    List<Resident> selectById(int a_id);
}
