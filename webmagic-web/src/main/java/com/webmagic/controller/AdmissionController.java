package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.AdmissionMapper;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.Admission;
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
@RequestMapping("admission")
public class AdmissionController extends BaseController {

	@Autowired
	private AdmissionMapper admissionMapper;
	@Autowired
	private WebsiteConfigMapper websiteConfigMapper;
	@RequestMapping("info")
	public ModelAndView info() {
		
		List<Admission> list = admissionMapper.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject(LIST, list);
		
		WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
		mv.addObject(ENTITY, wc);
		return mv;
	}
}
