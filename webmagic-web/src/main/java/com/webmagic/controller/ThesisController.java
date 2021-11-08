package com.webmagic.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.AttachmentMapper;
import com.webmagic.mapper.SysConfigMapper;
import com.webmagic.mapper.ThesisMapper;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.*;
import com.webmagic.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-10-02
 */
@Controller
@RequestMapping("thesis")
public class ThesisController extends BaseController {
	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private WebsiteConfigMapper websiteConfigMapper;
	@Autowired
	private ThesisService thesisService;
	@RequestMapping("")
	public ModelAndView _default() {
		ModelAndView mv = new ModelAndView("redirect:/thesis/index");
		return mv;
	}
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<ThesisAttachment> list = thesisService.queryThesisList(null);
		mv.addObject(LIST, list);
		WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
		mv.addObject(ENTITY, wc);
		SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
		mv.addObject("SYSCONFIG", sysConfig);
		return mv;
	}
}
