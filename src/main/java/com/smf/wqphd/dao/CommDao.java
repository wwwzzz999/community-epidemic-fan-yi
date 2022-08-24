package com.smf.wqphd.dao;


import com.smf.wqphd.bean.Comm;
import com.smf.wqphd.bean.Mate;
import com.smf.wqphd.vo.AddVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommDao extends BaseMapper<Comm>{
    Comm selectBydr(@Param("d_name") String d_name, @Param("r_name") String r_name);
    Mate selMqById(int a_id);

    @Select("SELECT a_id,CONCAT(c_area,'-',d_name,'-',r_name)AS a_location FROM tab_area")
    List<AddVo> selectTotal();

}
