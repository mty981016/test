package com.bdqn.ls.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.ls.pojo.Admin;
import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.pojo.Teachback;
import com.bdqn.ls.pojo.Worklisi;
import com.bdqn.ls.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TeachBackService teachBackService;
    @Autowired
    private WorkLisiService workLisiService;

    @RequestMapping("tomain")
    public String tomain(Model model) {
        model.addAttribute("mainlist1", infoService.mainlist1());
        model.addAttribute("mainlist2", infoService.mainlist2());
        return "main";
    }

    @RequestMapping("tolist")
    public String tolist(Model model) {      //进入信息列表页面
        List<Info> infoList = infoService.getAllInfo(1);
        model.addAttribute("typelist", typeService.findall());
        int count = infoService.getCount();
        model.addAttribute("count", count);
        model.addAttribute("limit", 8);
        model.addAttribute("infolist", infoList);
        model.addAttribute("level", 0);
        return "list";
    }

    @RequestMapping("todetails")
    public String todetails(int id, Model model) {
        model.addAttribute("info", infoService.findByid(id));
        return "details";
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model, HttpSession session) {       //进入添加信息页面
        model.addAttribute("typeList", typeService.findall());
        model.addAttribute("levelList", levelService.findAll());
        return "addinfo";
    }

    @RequestMapping("doAdd")
    public String doAdd(Info info, HttpSession session) {         //添加操作
        System.out.println("进来哦了");
        info.setCreatetime(new Date());
        //默认值
        if (info.getIsgo() == null) {
            info.setIsgo(0);
        }
        if (info.getIsrenzhi() == null) {
            info.setIsrenzhi(0);
        }
        int result1 = infoService.addInfo(info);
        int result2 = 0;
        if (result1 > 0) {
            List<Worklisi> list = (List<Worklisi>) session.getAttribute("workList");
            Info tempInfo = infoService.getNewInfo();
            info.getTeachback().setInfoid(tempInfo.getId());
            result2 = teachBackService.addTeachBack(info.getTeachback());
            if (result2 > 0) {
                int result3 = 0;
                if (list != null) {
                    for (Worklisi worklisi : list) {
                        worklisi.setInfoid(tempInfo.getId());
                        result3 += workLisiService.addWorkLisi(worklisi);
                    }
                    if (result3 == list.size()) {
                        System.out.println("添加成功");
                        session.removeAttribute("workList");
                        return "redirect:/info/tolist";
                    } else {
                        return "addinfo";
                    }
                } else {
                    System.out.println("添加成功");
                    session.removeAttribute("workList");
                    return "redirect:/info/tolist";
                }
            } else {
                System.out.println("添加失败");
                return "addinfo";
            }
        } else {
            System.out.println("添加失败");
            return "addinfo";
        }

    }

    @RequestMapping(value = "change")
    public String list1(HttpServletRequest request, Model model) {
        model.addAttribute("typelist", typeService.findall());
        int curr = Integer.parseInt(request.getParameter("curr"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        int count = infoService.getCount();
        List<Info> list = infoService.getList((curr - 1) * limit, limit);
        model.addAttribute("count", count);
        model.addAttribute("infolist", list);
        model.addAttribute("curr", curr);
        model.addAttribute("limit", limit);
        model.addAttribute("level", 0);
        return "list";
    }

    @PostMapping("upload")   //文件上传
    @ResponseBody
    public JSONObject upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        String filename = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(file.getOriginalFilename() + "原文件名");
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = filename + "." + ext;
        System.out.println(filenames + "---new");
        String pathname = "C:\\Users\\Administrator\\Pictures\\Camera Roll\\" + file.getOriginalFilename();
        try {
            file.transferTo(new File(pathname));
            resUrl.put("src", pathname);
            res.put("msg", "上传成功");
            res.put("code", 0);
            res.put("data", resUrl);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            resUrl.put("src", pathname);
            res.put("msg", "上传出错");
            res.put("code", 1);
            res.put("data", resUrl);
            return res;
        }
    }

    @RequestMapping(value = "change1")
    public String lchange(HttpServletRequest request, HttpSession session, Model model) {
        model.addAttribute("typelist", typeService.findall());
        Admin admin = (Admin) session.getAttribute("admin");

        int curr = Integer.parseInt(request.getParameter("curr"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        int count = infoService.getCountBylikelist(admin.getId());
        admin.setLikes(infoService.getMyLikeById(admin.getId(), (curr - 1) * limit, limit));
        System.out.println(curr + "--" + limit + "--" + count);
        model.addAttribute("count", count);
        model.addAttribute("curr", curr);
        model.addAttribute("limit", limit);
        return "ilike";
    }

    @RequestMapping(value = "getListByLevel1")
    public String getListByLevel1(@PathParam("level") int level, @PathParam("curr") int curr,
                                  @PathParam("limit") int limit, Model model,
                                  HttpServletRequest request) {
        List<Info> list = infoService.getInfoByLevel(level, (curr - 1) * limit, limit);
        model.addAttribute("infolist", list);
        model.addAttribute("count", infoService.getCountByLevel(level));
        model.addAttribute("curr", curr);
        model.addAttribute("limit", limit);
        model.addAttribute("level", 1);
        return "list";
    }

    @RequestMapping(value = "getListByLevel2")
    public String getListByLevel2(@PathParam("level") int level, @PathParam("curr") int curr,
                                  @PathParam("limit") int limit, Model model,
                                  HttpServletRequest request) {
        List<Info> list = infoService.getInfoByLevel(level, (curr - 1) * limit, limit);
        model.addAttribute("infolist", list);
        model.addAttribute("count", infoService.getCountByLevel(level));
        model.addAttribute("curr", curr);
        model.addAttribute("limit", limit);
        model.addAttribute("level", 2);
        return "list";
    }

    @RequestMapping(value = "getListByLevel3")
    public String getListByLevel3(@PathParam("level") int level, @PathParam("curr") int curr,
                                  @PathParam("limit") int limit, Model model,
                                  HttpServletRequest request) {
        List<Info> list = infoService.getInfoByLevel(level, (curr - 1) * limit, limit);
        model.addAttribute("infolist", list);
        model.addAttribute("count", infoService.getCountByLevel(level));
        model.addAttribute("curr", curr);
        model.addAttribute("limit", limit);
        model.addAttribute("level", 3);
        return "list";
    }

    private List<Worklisi> workList = new ArrayList<Worklisi>();

    @RequestMapping("addWork")
    public String addWork(@RequestParam(value = "date2") String date2, @RequestParam(value = "date3") String date3,
                          Worklisi worklisi, HttpSession session) {
        worklisi.setTimedian(date2 + "-" + date3);
        workList.add(worklisi);
        session.setAttribute("workList", workList);
        return "redirect:/info/toAdd";
    }

    @RequestMapping("delWork")
    public String delWork(HttpServletRequest request, HttpSession session) {
        String tempIndex = request.getParameter("index");
        int index = Integer.parseInt(tempIndex);
        List<Worklisi> workList = (List<Worklisi>) session.getAttribute("workList");
        workList.remove(index);
        session.setAttribute("workList", workList);
        return "redirect:/info/toAdd";
    }
}
