package com.admin.controller;

import com.admin.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("timeline")
public class TimelineController extends BaseController {
    
    @RequestMapping("page")
    public ModelAndView page(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
