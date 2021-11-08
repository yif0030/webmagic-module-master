package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.webmagic.model.WebsiteConfig;
import com.webmagic.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("wconfig")
public class WebsiteConfigController extends BaseController {

    @Autowired
    private WebsiteConfigService websiteConfigService;

	@RequestMapping("page")
	public ModelAndView config() {
        WebsiteConfig wc = websiteConfigService.get();
		ModelAndView mv = new ModelAndView();
		mv.addObject(RESULT, SUCCESS);
        mv.addObject(ENTITY, wc);
		return mv;
	}

	@RequestMapping("add")
    public ModelAndView add(WebsiteConfig wc) {
        ModelAndView mv = new ModelAndView();
        websiteConfigService.insert(wc);
	    return mv;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(WebsiteConfig wc) {
        websiteConfigService.update(wc);
        return SUCCESS;
    }
}
