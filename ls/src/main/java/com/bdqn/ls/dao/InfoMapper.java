package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Info;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface InfoMapper extends MyMapper<Info> {
    List<Info> findInfo(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize, Map<String,String> maps);
}