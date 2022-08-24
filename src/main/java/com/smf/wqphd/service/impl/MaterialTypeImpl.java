package com.smf.wqphd.service.impl;

import com.smf.wqphd.bean.MaterialType;
import com.smf.wqphd.dao.MaterialTypeMapper;
import com.smf.wqphd.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialTypeImpl extends DefaultServiceImpl<MaterialType> implements MaterialTypeService {

    @Autowired
    private MaterialTypeMapper materialTypeMapper;

    @Override
    public List<MaterialType> selectTotal() {
        return materialTypeMapper.selectTotal();
    }
}
