package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Info;
import tk.mybatis.MyMapper;

import java.util.List;

public interface InfoMapper extends MyMapper<Info> {
    List<Info> mainlist1();

    List<Info> mainlist2();

    List<Info> getAllInfo();

    int getCount();

    List<Info> getList(int curr, int limit);
}