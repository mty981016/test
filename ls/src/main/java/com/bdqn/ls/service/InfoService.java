package com.bdqn.ls.service;

import com.bdqn.ls.pojo.Info;

import java.util.List;
import java.util.Map;

public interface InfoService {
    List<Info> findInfo(int pageNo, int pageSize, Map<String,String> maps);
    int addInfo(Info info);
    Info findOneById(int id);
}
