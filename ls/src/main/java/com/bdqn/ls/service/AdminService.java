package com.bdqn.ls.service;


import com.bdqn.ls.pojo.Admin;

import java.util.List;

public interface AdminService {
    Admin login(Admin a);
    List<Admin> findAll();
    boolean addAdmin(Admin a);
    boolean updAdmin(Admin a);
    boolean delAdmin(Admin a);
}

