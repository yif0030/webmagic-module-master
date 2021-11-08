package com.admin.controller;

import com.webmagic.mapper.SysConfigMapper;
import com.webmagic.model.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SysConfigMapper sysConfigMapper;
    
    @RequestMapping("")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("admin");
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("sysCOnfig", sysConfig);
        return mv;
    }
}
