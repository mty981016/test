package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Info;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface InfoMapper extends MyMapper<Info> {
    List<Info> mainlist1();

    List<Info> mainlist2();

    List<Info> getAllInfo(@Param("isInit") int isInit);

    List<Info> getList(int curr, int limit);

    Info findByid(int id);

    List<Info> getMyLikeById(int id);

    List<Info> getInfoByLevel(int level, int curr, int limit);

    int getCountByLevel(int level);
}