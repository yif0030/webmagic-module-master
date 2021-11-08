package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseController {

    @RequestMapping("")
    public ModelAndView _default(){
        return new ModelAndView("redirect:/home/index");
    }

    @RequestMapping("/")
    public ModelAndView _default2(){
        return new ModelAndView("redirect:/home/index");
    }
}
