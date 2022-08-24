package com.smf.wqphd.dao;

import com.smf.wqphd.bean.PeopleManage;

import java.util.List;

public interface PeopleManageMapper extends BaseMapper<PeopleManage>{

    List<PeopleManage> selectBystatus(String h_status);
}
