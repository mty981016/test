package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.TypeMapper;
import com.bdqn.ls.pojo.Type;
import com.bdqn.ls.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> findall() {
        return typeMapper.selectAll();
    }
}
