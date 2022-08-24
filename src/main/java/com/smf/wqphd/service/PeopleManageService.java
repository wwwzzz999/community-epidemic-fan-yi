package com.smf.wqphd.service;

import com.smf.wqphd.bean.PeopleManage;

import java.util.List;

public interface PeopleManageService extends BaseService<PeopleManage>{

    List<PeopleManage> selectBystatus(String h_status);
}
