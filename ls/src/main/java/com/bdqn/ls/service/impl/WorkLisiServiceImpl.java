package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.WorklisiMapper;
import com.bdqn.ls.pojo.Worklisi;
import com.bdqn.ls.service.WorkLisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkLisiServiceImpl implements WorkLisiService {

    @Autowired
    private WorklisiMapper worklisiMapper;

    @Override
    public int addWorkLisi(Worklisi worklisi) {
        return worklisiMapper.insert(worklisi);
    }
}
