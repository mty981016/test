package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Mylike;
import tk.mybatis.MyMapper;

import java.util.List;

public interface MylikeMapper extends MyMapper<Mylike> {

    List<Info> getList(int curr, int limit);
}