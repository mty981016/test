package com.bdqn.ls.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.ls.pojo.*;
import com.bdqn.ls.service.*;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
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
            System.out.println(tempInfo.getId() + "-----newId");
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

        String search = request.getParameter("search");
        int curr = Integer.parseInt(request.getParameter("curr"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<Info> list = new ArrayList<Info>();
        Map<String, Object> pamMap = new HashMap<String, Object>();
        if (search != null && search != "") {

            List<Integer> parmTypes = new ArrayList<Integer>();
            List<String> parmXueli = new ArrayList<String>();
            List<Integer> isgo = new ArrayList<Integer>();
            List<Integer> isrenzhi = new ArrayList<Integer>();
            boolean b = false;
            String[] searchs = search.split("、");
            for (int i = 0; i < searchs.length; i++) {
                for (Type type : typeService.findall()) {
                    if (searchs[i].equals(type.getName())) {
                        parmTypes.add(type.getId());
                        b = true;
                        break;
                    }
                }
                if (b) {
                    b = false;
                    continue;
                } else {
                    if ("大专".equals(searchs[i])) {
                        parmXueli.add("大专");
                    } else if ("本科".equals(searchs[i])) {
                        parmXueli.add("本科");
                    } else if ("研究生".equals(searchs[i])) {
                        parmXueli.add("研究生");
                    } else if ("硕士".equals(searchs[i])) {
                        parmXueli.add("硕士");
                    } else if ("博士".equals(searchs[i])) {
                        parmXueli.add("博士");
                    } else if ("在职有跳槽意向".equals(searchs[i])) {
                        isgo.add(1);
                        isrenzhi.add(1);
                    } else if ("在职无跳槽意向".equals(searchs[i])) {
                        isgo.add(0);
                    } else if ("不在职".equals(searchs[i])) {
                        isrenzhi.add(1);
                    } else {
                        pamMap.put("name", searchs[i]);
                    }
                }
            }
            pamMap.put("typeid", parmTypes);
            pamMap.put("xueli;", parmXueli);
            pamMap.put("isgo;", isgo);
            pamMap.put("isrenzhi;", isrenzhi);
        }
        list = infoService.getList((curr - 1) * limit, limit, pamMap);

        int count = infoService.getCountBysearch(pamMap);

        model.addAttribute("search", search);
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
        String pathname = "E:\\GIt代码仓库\\test\\ls\\src\\main\\resources\\static\\uploadimg\\" + filenames;
        try {
            file.transferTo(new File(pathname));
            resUrl.put("src", "/uploadimg/" + filenames);
            res.put("msg", "上传成功");
            res.put("code", 0);
            res.put("data", resUrl);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            resUrl.put("src", "/uploadimg/" + filenames);
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

    @RequestMapping("search")
    public String search(Model model, @RequestParam(value = "search", required = false) String search) {
        Map<String, Object> pamMap = new HashMap<String, Object>();
        List<Integer> parmTypes = new ArrayList<Integer>();
        List<String> parmXueli = new ArrayList<String>();
        List<Integer> isgo = new ArrayList<Integer>();
        List<Integer> isrenzhi = new ArrayList<Integer>();
        boolean b = false;
        String[] searchs = search.split("、");
        for (int i = 0; i < searchs.length; i++) {
            for (Type type : typeService.findall()
            ) {
                if (searchs[i].equals(type.getName())) {
                    parmTypes.add(type.getId());
                    b = true;
                    break;
                }
            }
            if (b) {
                b = false;
                continue;
            } else {
                if ("大专".equals(searchs[i])) {
                    parmXueli.add("大专");
                } else if ("本科".equals(searchs[i])) {
                    parmXueli.add("本科");
                } else if ("研究生".equals(searchs[i])) {
                    parmXueli.add("研究生");
                } else if ("硕士".equals(searchs[i])) {
                    parmXueli.add("硕士");
                } else if ("博士".equals(searchs[i])) {
                    parmXueli.add("博士");
                } else if ("在职有跳槽意向".equals(searchs[i])) {
                    isgo.add(1);
                    isrenzhi.add(1);
                } else if ("在职无跳槽意向".equals(searchs[i])) {
                    isgo.add(0);
                } else if ("不在职".equals(searchs[i])) {
                    isrenzhi.add(1);
                } else {
                    pamMap.put("name", searchs[i]);
                }
            }
        }
        pamMap.put("typeid", parmTypes);
        pamMap.put("xueli;", parmXueli);
        pamMap.put("isgo;", isgo);
        pamMap.put("isrenzhi;", isrenzhi);
        List<Info> infoList = infoService.getList(0, 8, pamMap);

        model.addAttribute("search", search);
        model.addAttribute("count", infoService.getCountBysearch(pamMap));
        model.addAttribute("limit", 8);
        model.addAttribute("level", 0);
        model.addAttribute("typelist", typeService.findall());
        model.addAttribute("infolist", infoList);
        return "list";
    }

}
