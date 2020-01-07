package com.bdqn.ls.dao;

import com.bdqn.ls.pojo.Teachback;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TeachbackMapper extends MyMapper<Teachback> {
    List<Integer> findInfoidByxueli(@Param(value = "xueli") List<String> xueli);
}