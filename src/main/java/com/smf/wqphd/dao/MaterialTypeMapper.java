package com.smf.wqphd.dao;

import com.smf.wqphd.bean.MaterialType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialTypeMapper extends BaseMapper<MaterialType>{


    @Select("SELECT * FROM tbl_materialtype")
    public List<MaterialType> selectTotal();
}
