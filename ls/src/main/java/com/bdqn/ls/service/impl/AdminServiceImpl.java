package com.bdqn.ls.service.impl;


import com.bdqn.ls.dao.AdminMapper;
import com.bdqn.ls.dao.InfoMapper;
import com.bdqn.ls.dao.LikeMapper;
import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Like;
import com.bdqn.ls.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public Admin login(Admin a)
    {
        Admin aa=adminMapper.selectOne(a);
        List<Like> likeList=likeMapper.selectByExample(aa.getId());
        List<Info> likeInfo=new ArrayList<Info>();
        for (Like like:likeList
             ) {
            likeInfo.add(infoMapper.selectOneByExample(like.getInfoid()));

        }
        System.out.println(likeInfo.size());
        aa.setLikes(likeInfo);
      return aa;
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }

    @Override
    public boolean addAdmin(Admin a) {
        if(adminMapper.insert(a)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updAdmin(Admin a) {
        if(adminMapper.updateByPrimaryKey(a)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delAdmin(Admin a) {
        if(adminMapper.updateByPrimaryKey(a)>0){
            return true;
        }
        return false;
    }

}
