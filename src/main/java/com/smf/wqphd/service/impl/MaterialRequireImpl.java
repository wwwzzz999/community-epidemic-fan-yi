package com.smf.wqphd.service.impl;

import com.smf.wqphd.dao.MaterialRequireMapper;
import com.smf.wqphd.bean.MaterialRequire;
import com.smf.wqphd.service.MaterialRequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialRequireImpl extends DefaultServiceImpl<MaterialRequire> implements MaterialRequireService {

    @Autowired
    private MaterialRequireMapper materialRequireMapper;

}
