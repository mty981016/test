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
    public List<Info> findInfo(int pageNo, int pageSize, Map<String, String> maps) {

        return null;
    }

    @Override
    public int addInfo(Info info) {
        return infoMapper.insert(info);
    }

    @Override
    public Info findOneById(int id) {

        return infoMapper.selectByPrimaryKey(id);
    }
}
