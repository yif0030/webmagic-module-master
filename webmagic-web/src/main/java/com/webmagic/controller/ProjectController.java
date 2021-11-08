package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.WebsiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-10-02
 */
@Controller
@RequestMapping("project")
public class ProjectController extends BaseController {

    @Autowired
    private WebsiteConfigMapper websiteConfigMapper;

	@RequestMapping("info")
	public ModelAndView info() {
		ModelAndView mv = new ModelAndView();

        WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
        mv.addObject(ENTITY, wc);
		return mv;
	}
	
}
