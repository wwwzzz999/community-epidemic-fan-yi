package com.smf.wqphd.service;

import com.smf.wqphd.bean.MaterialType;

import java.util.List;

public interface MaterialTypeService extends BaseService<MaterialType>{

    public List<MaterialType> selectTotal();

}
