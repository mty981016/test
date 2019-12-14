package com.bdqn.ls.service;

import com.bdqn.ls.pojo.Info;

import java.util.List;
import java.util.Map;

public interface InfoService {
    List<Info> findInfo(int pageNo, int pageSize, Map<String, String> maps);

    int addInfo(Info info);

    Info findOneById(int id);

    Info findByid(int id);

    List<Info> mainlist1();

    List<Info> mainlist2();

    List<Info> getAllInfo(int isInit);

    int getCount();

    List<Info> getList(int curr, int limit);

    List<Info> getInfoByLevel(int level, int curr, int limit);

    List<Info> getMyLikeById(int id);

    int getCountByLevel(int level);

}
