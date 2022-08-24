package com.smf.wqphd.service;



import com.smf.wqphd.bean.Colpic;
import com.smf.wqphd.bean.Visdata;

import java.util.List;

public interface VisService {
    List<Visdata> picdataList();
    List<Colpic> colList();
}
