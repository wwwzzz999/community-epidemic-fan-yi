package com.smf.wqphd.dao;



import com.smf.wqphd.bean.Colpic;
import com.smf.wqphd.bean.Visdata;

import java.util.List;

public interface visDao {
    List<Visdata> picdataList();
    List<Colpic> colList();
}
