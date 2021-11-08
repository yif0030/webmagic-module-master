package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.admin.vo.ResultMap;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.HomeSwiperMapper;
import com.webmagic.mapper.InfoTypeMapper;
import com.webmagic.mapper.InstituteInformationMapper;
import com.webmagic.mapper.SysConfigMapper;
import com.webmagic.model.*;
import com.webmagic.service.HomepageService;
import com.webmagic.service.InformationService;
import com.webmagic.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Controller
@RequestMapping("homepage")
public class HomepageController extends BaseController {
	@Autowired
	private HomepageService homepageService;
	@Autowired
	private InstituteService instituteService;
	@Autowired
	private InformationService informationService;
	@Autowired
	private HomeSwiperMapper homeSwiperMapper;
	@Autowired
    private SysConfigMapper sysConfigMapper;
	@Autowired
    private InfoTypeMapper infoTypeMapper;
	@Autowired
    private InstituteInformationMapper infoMapper;
	
	@RequestMapping("swiper")
	public ModelAndView swiper(ModelAndView mv){
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        List<HomeSwiper> list = homeSwiperMapper.selectAll();
        mv.addObject(LIST, list);
        mv.addObject("sysConfig", sysConfig);
        mv.addObject(RESULT, SUCCESS);
	    return mv;
	}
	
	@RequestMapping(value="swiper/update", method=RequestMethod.POST)
	@ResponseBody
	public ResultMap swiperConfig(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		try {
			String fileName = file.getOriginalFilename();
			if (file != null && fileName != null && fileName.length() > 0) {
				String newFileName = UUID.randomUUID() + fileName;
                SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
				File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/swiper", newFileName);
				File fileParent = targetFile.getParentFile();
				if(!fileParent.exists()){
					fileParent.mkdirs();
				}
				file.transferTo(targetFile);
				HomeSwiper homeSwiper = new HomeSwiper();
				homeSwiper.setFilePath("/uploads/swiper/"+ newFileName);
				homeSwiper.setFileName(newFileName);
				homeSwiperMapper.insert(homeSwiper);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        ResultMap resultMap = new ResultMap();
        resultMap.setResult(SUCCESS);
		return resultMap;
	}

    @RequestMapping("swiper/del")
    @ResponseBody
	public String delSwiper(Integer id){
        homeSwiperMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
	@RequestMapping("institute/introduce")
	public ModelAndView introduce() {
		Institute institute = instituteService.get(0);
		ModelAndView mv = new ModelAndView();
		mv.addObject(RESULT, SUCCESS);
		mv.addObject(ENTITY, institute);
		return mv;
	}
	
	@RequestMapping("institute/information")
	public ModelAndView information() {
		ModelAndView mv = new ModelAndView();
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("website", sysConfig.getWebUrl());
		return mv;
	}

    @RequestMapping("institute/addInfoPage")
    public ModelAndView addInfoPage() {
        List<InfoType> infoTypes = infoTypeMapper.selectAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject(LIST, infoTypes);
        return mv;
    }
	
	@RequestMapping("institute/info/list")
	@ResponseBody
	public Map<String, Object> infoList(InstituteInformation info, int page, int limit) throws InvocationTargetException, IllegalAccessException {
		
		List<InstituteInformation> list = informationService.select(info);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", 0);
		resultMap.put("message", "");
		resultMap.put("total", list.size());
		Map<String, Object> item = new HashMap<>();
		item.put("item", list);
		resultMap.put("data", item);
		
		return resultMap;
	}

    @RequestMapping(value = "institute/info/add", method = RequestMethod.POST)
    public ModelAndView addInfo(MultipartFile img, InstituteInformation info) {
        ModelAndView mv = new ModelAndView("/homepage/institute/addInfoPage");
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        if (img != null) {
            String fileName = img.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/info/", newFileName);
            File fileParent = targetFile.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            try {
                img.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
                mv.addObject(RESULT, FAILED);
            }
            info.setMainImg("/uploads/info/" + newFileName);
        } else {
            info.setMainImg("/images/news/3.jpg");
        }
        info.setId(IdWorker.getIdStr());
        info.setCreateAt(new Date());
        infoMapper.insert(info);
        mv.addObject(RESULT, SUCCESS);
        return mv;
    }

    @RequestMapping("institute/editInfoPage")
    public ModelAndView editInfoPage(String id) {
        InstituteInformation info = infoMapper.selectByPrimaryKey(id);
        List<InfoType> infoTypes = infoTypeMapper.selectAll();
        ModelAndView mv = new ModelAndView();
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("website", sysConfig.getWebUrl());
        mv.addObject(LIST, infoTypes);
        mv.addObject(ENTITY, info);
        return mv;
    }

    @RequestMapping(value = "institute/info/edit", method = RequestMethod.POST)
    public ModelAndView editInfo(MultipartFile img, InstituteInformation info) {
        ModelAndView mv = new ModelAndView("redirect:/homepage/institute/editInfoPage");
        mv.addObject("id", info.getId());
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        if (img != null) {
            String fileName = img.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/infoimg/", newFileName);
            File fileParent = targetFile.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            try {
                img.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
                mv.addObject(RESULT, FAILED);
            }
            info.setMainImg( "/uploads/infoimg/" + newFileName);
        } else {
            info.setMainImg("/images/news/3.jpg");
        }
        info.setCreateAt(new Date());
        infoMapper.updateByPrimaryKey(info);
        return mv;
    }

    @RequestMapping("institute/info/del")
    @ResponseBody
    public String delInfo(String id) {
        int count = infoMapper.deleteByPrimaryKey(id);
	    return SUCCESS;
    }
}
