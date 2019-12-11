package com.bdqn.ls.controller;

import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl asi;

    @RequestMapping("/")
    public String toLogin() {
        return "index";
    }

    @RequestMapping("login")
    public String login(Admin admin, HttpSession session, Model model) {
        model.addAttribute("msg", "");
        Admin aa = asi.login(admin);
        if (aa != null) {
            session.setAttribute("admin", aa);
            return "main";//调用config包下配置类所实现的视图解析器进行跳转
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }


    }
}
