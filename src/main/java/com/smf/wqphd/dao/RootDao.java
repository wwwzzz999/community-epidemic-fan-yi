package com.smf.wqphd.dao;

import com.smf.wqphd.bean.Root_user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RootDao {
    List<Root_user> selectAll();
    Root_user selectByName(String name);
    boolean updateByName(@Param("name") String name, @Param("password") String password);
}
