package com.bdqn.ls.service.impl;

import com.bdqn.ls.dao.MylikeMapper;
import com.bdqn.ls.service.MyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyLikeServiceImpl implements MyLikeService {
    @Autowired
    private MylikeMapper mylikeMapper;

}
