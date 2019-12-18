package com.bdqn.ls.controller;

import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.service.InfoService;
import com.bdqn.ls.service.MyLikeService;
import com.bdqn.ls.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl asi;
    @Autowired
    private InfoService infoService;
    @Autowired
    private MyLikeService myLikeService;

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
            return "redirect:/info/tomain";//调用config包下配置类所实现的视图解析器进行跳转
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }

    }

    @RequestMapping("tolikeList")
    public String tolikeList(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        List<Info> list = infoService.getMyLikeById(admin.getId());
        admin.setLikes(list);
        session.setAttribute("admin", admin);
        int count = myLikeService.getCount();
        model.addAttribute("count", count);
        model.addAttribute("limit", 12);
        model.addAttribute("curr", 1);
        return "ilike";
    }

    @RequestMapping(value = "logout")
    public String loginOut(HttpSession session, Model model) {
        session.removeAttribute("admin");
        return "index";
    }
}
