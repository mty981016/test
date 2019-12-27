package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.TeachbackMapper;
import com.bdqn.ls.pojo.Teachback;
import com.bdqn.ls.service.TeachBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachBackServiceImpl implements TeachBackService {

    @Autowired
    private TeachbackMapper teachbackMapper;

    @Override
    public int addTeachBack(Teachback teachback) {
        return teachbackMapper.insert(teachback);
    }
}
