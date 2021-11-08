package com.admin.controller;

import com.admin.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 实验室功能页Controller
 */
@Controller
@RequestMapping("loboratory")
public class LoboratoryController extends BaseController {

    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        return mv;
    }

}
