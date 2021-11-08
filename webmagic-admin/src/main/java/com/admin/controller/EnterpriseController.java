package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.EnterpriseMapper;
import com.webmagic.mapper.PageIntroduceMapper;
import com.webmagic.mapper.SysConfigMapper;
import com.webmagic.model.Enterprise;
import com.webmagic.model.PageIntroduce;
import com.webmagic.model.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("enterprise")
public class EnterpriseController extends BaseController {
    
    @Autowired
    private EnterpriseMapper enterpriseMapper;
    @Autowired
    private PageIntroduceMapper introduceMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    
    @RequestMapping("page")
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView();
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("website", sysConfig.getWebUrl());
        return mv;
    }
    
    @RequestMapping("addPage")
    public ModelAndView addPage(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping("editPage")
    public ModelAndView editPage(String id){
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        enterprise.setLogo(sysConfig.getWebUrl() + enterprise.getLogo());
        mv.addObject(ENTITY, enterprise);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(){
        
        List<Enterprise> list = enterpriseMapper.selectAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 0);
        resultMap.put("message", "");
        resultMap.put("total", list.size());
        Map<String, Object> item = new HashMap<>();
        item.put("item", list);
        resultMap.put("data", item);
        return resultMap;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(MultipartFile logoFile, Enterprise enterprise){
        ModelAndView mv = new ModelAndView("redirect:/enterprise/addPage");
        if (logoFile != null ) {
            String fileName = logoFile.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/logo/", newFileName);
            File fileParent = targetFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            try {
                logoFile.transferTo(targetFile);
                enterprise.setLogo("/uploads/logo/"+ newFileName);
                enterprise.setId(IdWorker.getIdStr());
                enterprise.setCreateTime(new Date());
                enterpriseMapper.insert(enterprise);
                mv.addObject(RESULT, SUCCESS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView edit(MultipartFile logoFile, Enterprise enterprise){
        ModelAndView mv = new ModelAndView("redirect:/enterprise/editPage");
        if (logoFile != null ) {
            String fileName = logoFile.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/logo/", newFileName);
            File fileParent = targetFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            try {
                logoFile.transferTo(targetFile);
                enterprise.setLogo("/uploads/logo/"+ newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        enterprise.setCreateTime(new Date());
        enterpriseMapper.updateByPrimaryKey(enterprise);
        return mv;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        enterpriseMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
    @RequestMapping("introduce/edit")
    @ResponseBody
    public String editIntroduce(PageIntroduce introduce) {
        introduceMapper.updateByPrimaryKey(introduce);
        return SUCCESS;
    }
}
