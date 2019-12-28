package com.bdqn.ls.service;

import com.bdqn.ls.pojo.Info;

import java.util.List;
import java.util.Map;

public interface InfoService {

    int addInfo(Info info);

    Info findByid(int id);

    List<Info> mainlist1();

    List<Info> mainlist2();

    List<Info> getAllInfo(int isInit);

    int getCount();

    List<Info> getList(int curr, int limit,Map<String,Object> parMap);

    List<Info> getInfoByLevel(int level, int curr, int limit);

    List<Info> getMyLikeById(int id, int curr, int limit);

    int getCountByLevel(int level);

    int getCountBylikelist(int id);

    Info getNewInfo();

    int getCountBysearch(Map<String,Object> map);

}
