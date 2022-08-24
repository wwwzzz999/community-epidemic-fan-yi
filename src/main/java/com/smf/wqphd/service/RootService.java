package com.smf.wqphd.service;


import com.smf.wqphd.bean.Root_user;

import java.util.List;

public interface RootService {
   public List<Root_user> selectAll();
   Root_user selectByName(String name);
   boolean updateByName(String name,String password);
}
