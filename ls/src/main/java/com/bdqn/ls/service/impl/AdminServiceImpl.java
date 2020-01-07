package com.bdqn.ls.service.impl;


import com.bdqn.ls.dao.AdminMapper;
import com.bdqn.ls.dao.InfoMapper;
import com.bdqn.ls.dao.MylikeMapper;
import com.bdqn.ls.dao.SearchlisiMapper;
import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Mylike;
import com.bdqn.ls.pojo.Searchlisi;
import com.bdqn.ls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private MylikeMapper likeMapper;
    @Autowired
    private InfoMapper infoMapper;


    @Override
    public Admin login(Admin a) {

        return adminMapper.selectOne(a);
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }

    @Override
    public boolean addAdmin(Admin a) {
        if (adminMapper.insert(a) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updAdmin(Admin a) {
        if (adminMapper.updateByPrimaryKey(a) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delAdmin(Admin a) {
        if (adminMapper.updateByPrimaryKey(a) > 0) {
            return true;
        }
        return false;
    }

}
