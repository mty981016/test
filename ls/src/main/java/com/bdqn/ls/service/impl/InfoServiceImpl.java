package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.InfoMapper;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public int addInfo(Info info) {
        return infoMapper.insert(info);
    }

    @Override
    public Info findByid(int id) {
        return infoMapper.findByid(id);
    }


    @Override
    public List<Info> mainlist1() {
        return infoMapper.mainlist1();
    }

    @Override
    public List<Info> mainlist2() {
        return infoMapper.mainlist2();
    }

    @Override
    public List<Info> getAllInfo(int isInit) {
        return infoMapper.getAllInfo(isInit);
    }

    @Override
    public int getCount() {
        return infoMapper.selectCount(new Info());
    }

    @Override
    public List<Info> getList(int curr, int limit,Map<String,Object> parMap) {
        return infoMapper.getList(curr, limit,parMap);
    }

    @Override
    public List<Info> getMyLikeById(int id,int curr, int limit) {
        return infoMapper.getMyLikeById(id,curr,limit);
    }

    @Override
    public List<Info> getInfoByLevel(int level, int curr, int limit) {
        return infoMapper.getInfoByLevel(level, curr, limit);
    }

    @Override
    public int getCountByLevel(int level) {
        return infoMapper.getCountByLevel(level);
    }

    @Override
    public int getCountBylikelist(int id) {
        return infoMapper.getCountBylikelist(id);
    }

    @Override
    public Info getNewInfo() {
        return infoMapper.getNewInfo();
    }

    @Override
    public int getCountBysearch(Map<String, Object> map) {
        return infoMapper.getCountBysearch(map);
    }
}
