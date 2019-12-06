package com.bdqn.ls.controller;

import com.bdqn.ls.pojo.Info;
import com.bdqn.ls.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @RequestMapping("toAdd")
    public String toAdd(){
        return "addinfo";
    }
    @RequestMapping("doAdd")
    public String doAdd(Info info){
        int result=infoService.addInfo(info);
        if(result>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        return "adminBackground";
    }
}
