package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.MylikeMapper;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Mylike;
import com.bdqn.ls.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyLikeServiceImpl implements MyLikeService {
    @Autowired
    private MylikeMapper mylikeMapper;

    @Override
    public int getCount() {
        return mylikeMapper.selectCount(new Mylike());
    }

    @Override
    public List<Info> getList(int curr, int limit) {
        return mylikeMapper.getList(curr, limit);
    }
}
