package com.bdqn.ls.service.impl;


import com.bdqn.ls.dao.AdminMapper;
import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(Admin a) {
      return adminMapper.selectOne(a);
    }
}
