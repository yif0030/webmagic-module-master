package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.webmagic.model.SysConfig;
import com.webmagic.mapper.SysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sysconfig")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        SysConfig sc = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject(RESULT, SUCCESS);
        mv.addObject(ENTITY, sc);
        return mv;
    }
}
