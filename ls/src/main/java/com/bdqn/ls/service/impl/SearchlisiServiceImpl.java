package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.SearchlisiMapper;
import com.bdqn.ls.pojo.Searchlisi;
import com.bdqn.ls.service.SearchlisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class SearchlisiServiceImpl implements SearchlisiService {
    @Autowired
    private SearchlisiMapper searchlisiMapper;
    @Override
    public List<Searchlisi> findByadminid(int id) {
        Example example  =new Example(Searchlisi.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("adminid",id);
        return searchlisiMapper.selectByExample(example);
    }
}
