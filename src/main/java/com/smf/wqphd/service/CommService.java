package com.smf.wqphd.service;


import com.smf.wqphd.bean.Comm;
import com.smf.wqphd.bean.Mate;
import com.smf.wqphd.vo.AddVo;

import java.util.List;

public interface CommService extends BaseService<Comm>{
    Comm selectBydr(String d_name, String r_name);
    Mate selMqById(int m_id);

    List<AddVo> selectTotal();

}
