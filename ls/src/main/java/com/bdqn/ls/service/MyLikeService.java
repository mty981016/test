package com.bdqn.ls.service;

import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Mylike;

import java.util.List;

public interface MyLikeService {

    int getCount();

    List<Info> getList(int curr, int limit);

}

