package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.CourseTeachMapper;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.CourseTeach;
import com.webmagic.model.WebsiteConfig;
import com.webmagic.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-10-02
 */
@Controller
@RequestMapping("courseteach")
public class CourseTeachController extends BaseController {

	@Autowired
	private CourseTeachMapper courseTeachMapper;
	@Autowired
	private WebsiteConfigMapper websiteConfigMapper;
	@RequestMapping("page")
	public ModelAndView page() {
		
		List<CourseTeach> list = courseTeachMapper.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject(LIST, list);
		
		WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
		mv.addObject(ENTITY, wc);
		return mv;
	}
}
