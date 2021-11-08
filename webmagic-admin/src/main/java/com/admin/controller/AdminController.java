package com.admin.controller;

import com.webmagic.mapper.*;
import com.webmagic.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 后台
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-09-30
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private InstituteInformationMapper informationMapper;
    @Autowired
    private WebsiteLogMapper logMapper;
    @Autowired
    private ThesisMapper thesisMapper;
    @Autowired
    private ScientificResearchProjectMapper srpMapper;
    @Autowired
    private DataAndCodeMapper dataAndCodeMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;

	@RequestMapping("")
	public ModelAndView _default() {
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
	}

	@RequestMapping("welcome")
	public ModelAndView welcome() {

        List<Member> memberList = memberMapper.selectAll();
        int memberCount = memberList.size();
        List<InstituteInformation> infoList = informationMapper.selectAll();
        int infoCount = infoList.size();
		ModelAndView mv = new ModelAndView();
        WebsiteLog log = logMapper.selectByPrimaryKey("0");
        long visitCount = log.getVisite();
        List<Thesis> thesisList = thesisMapper.selectAll();
        int thesisCount = thesisList.size();
        List<ScientificResearchProject> srpList = srpMapper.selectAll();
        int srpCount = srpList.size();
        List<DataAndCode> dataAndCodes = dataAndCodeMapper.selectAll();
        int dataCount = dataAndCodes.size();

        mv.addObject("memberCount", memberCount);
        mv.addObject("infoCount", infoCount);
        mv.addObject("visitCount", visitCount);
        mv.addObject("thesisCount", thesisCount);
        mv.addObject("srpCount", srpCount);
        mv.addObject("dataCount", dataCount);

		return mv;
	}
	
	@RequestMapping("member-list")
	public ModelAndView memberList() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
