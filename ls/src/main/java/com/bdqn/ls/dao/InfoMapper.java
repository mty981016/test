package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Info;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface InfoMapper extends MyMapper<Info> {
    List<Info> mainlist1();

    List<Info> mainlist2();

    List<Info> getAllInfo(@Param("isInit") int isInit);

    List<Info> getList(int curr, int limit, @Param("map")Map<String, Object> map);

    Info findByid(int id);

    int getCount();

    List<Info> getMyLikeById(int id, int curr, int limit);

    List<Info> getInfoByLevel(int level, int curr, int limit);

    int getCountByLevel(int level);

    int getCountBylikelist(int id);

    Info getNewInfo();

    int getCountBysearch(@Param("map")Map<String, Object> map);
}