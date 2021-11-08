package com.webmagic.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dfgg.util.CopyUtils;
import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.*;
import com.webmagic.model.*;
import com.webmagic.service.InformationService;
import com.webmagic.service.InstituteService;
import com.webmagic.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Wrapper;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController extends BaseController {
	
	@Autowired
	private WebsiteConfigMapper websiteConfigMapper;
	@Autowired
	private InstituteService instituteService;
    @Autowired
    private InformationService informationService;
	@Autowired
	private HomeSwiperMapper homeSwiperMapper;
	@Autowired
    private WebsiteLogMapper logMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private SysConfigMapper sysConfigMapper;
 
	@RequestMapping("")
	public ModelAndView _default() {
		ModelAndView mv = new ModelAndView("redirect:/home/index");
		return mv;
	}
	
	@RequestMapping("index")
	public ModelAndView index() {
		
		SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        InstituteInformation info = new InstituteInformation();
        List<InstituteInformation> list = informationService.select(info);
		List<HomeSwiper> swipers = homeSwiperMapper.selectAll();
        ModelAndView mv = new ModelAndView();
		mv.addObject(RESULT, SUCCESS);
        mv.addObject("info_list", list);
		Institute institute = instituteService.get(0);
		mv.addObject("institute", institute);
		mv.addObject("swipers", swipers);
		mv.addObject("website", sysConfig.getWebUrl());
        WebsiteLog log = logMapper.selectByPrimaryKey("0");
        int count = log.getVisite();
        log.setVisite(++count);
        logMapper.updateByPrimaryKey(log);
        
        EntityWrapper wrapper = new EntityWrapper<Notice>();
        wrapper.where("1=1");
        wrapper.last("limit 8");
        wrapper.orderBy("create_time", false);
        List<Notice> notices = noticeMapper.selectList(wrapper);
        mv.addObject("notices", notices);
		
		WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
		mv.addObject(ENTITY, wc);
		return mv;
	}
}
