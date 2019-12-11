package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.LevelMapper;
import com.bdqn.ls.pojo.Level;
import com.bdqn.ls.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelMapper levelMapper;
    @Override
    public List<Level> findAll() {
        List<Level> list = levelMapper.selectAll();

        return  list;

    }
}
