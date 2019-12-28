package com.bdqn.ls.service;

import com.bdqn.ls.pojo.Searchlisi;

import java.util.List;

public interface SearchlisiService {
    List<Searchlisi> findByadminid(int id);
}
