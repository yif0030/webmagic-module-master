package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.admin.vo.ResultMap;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.*;
import com.webmagic.model.*;
import com.webmagic.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 论文著作
 */
@Controller
@RequestMapping("thesis")
public class ThesisController extends BaseController {
    @Autowired
    private ThesisMapper thesisMapper;
    @Autowired
    private AttachmentMapper attachmentMapper;
    @Autowired
    private ThesisService thesisService;
    @Autowired
    private PageIntroduceMapper introduceMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    
    @RequestMapping("page")
    public ModelAndView page() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping("addPage")
    public ModelAndView addPage(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping("editPage")
    public ModelAndView editPage(String id){
        Thesis thesis = thesisMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, thesis);
        return mv;
    }
    
    @RequestMapping("attachmentPage")
    public ModelAndView attachmentPage(String fid){
        EntityWrapper<Attachment> wrapper = new EntityWrapper<>();
        wrapper.orderBy("create_time", false);
        wrapper.where("foreign_id={0}", fid);
        List<Attachment> attachmentList = attachmentMapper.selectList(wrapper);
        ModelAndView mv = new ModelAndView();
        mv.addObject("attachmentList", attachmentList);
        mv.addObject("thesisId", fid);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(Thesis thesis){
        List<ThesisAttachment> resultList = thesisService.queryThesisList(thesis);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 0);
        resultMap.put("message", "");
        resultMap.put("total", resultList.size());
        Map<String, Object> item = new HashMap<>();
        item.put("item", resultList);
        resultMap.put("data", item);
        return resultMap;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String add(Thesis thesis){
        thesis.setId(IdWorker.getIdStr());
        thesis.setCreateTime(new Date());
        thesisMapper.insert(thesis);
        return SUCCESS;
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public String edit(Thesis thesis){
        thesis.setCreateTime(new Date());
        thesisMapper.updateByPrimaryKey(thesis);
        return SUCCESS;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        thesisMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
    @RequestMapping("introduce/edit")
    @ResponseBody
    public String editIntroduce(PageIntroduce introduce) {
        introduceMapper.updateByPrimaryKey(introduce);
        return SUCCESS;
    }
    
    
    @RequestMapping(value = "uploads", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap uploads(MultipartFile[] files, String thesisId, HttpServletRequest request){
        ResultMap resultMap = new ResultMap();
        if(files!=null&&files.length>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                for (MultipartFile multipartFile : files) {
                    String fileName = multipartFile.getOriginalFilename();
                    String newFileName = sdf.format(new Date()) + fileName;
                    SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
                    File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/attathment/thesis/", newFileName);
                    File fileParent = targetFile.getParentFile();
                    if(!fileParent.exists()){
                        fileParent.mkdirs();
                    }
                    multipartFile.transferTo(targetFile);
                    Attachment attachment = new Attachment();
                    attachment.setId(IdWorker.getIdStr());
                    attachment.setPath("/uploads/attathment/thesis/"+ newFileName);
                    attachment.setCreateTime(new Date());
                    attachment.setForeignId(thesisId);
                    attachment.setFileName(fileName);
                    attachment.setFileSize(multipartFile.getSize());
                    attachmentMapper.insert(attachment);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultMap.setResult(SUCCESS);
            return resultMap;
        }
        resultMap.setResult(FAILED);
        return resultMap;
    }
    
    @RequestMapping("delAttachment")
    @ResponseBody
    public String delAttachment(String attachmentId){
        attachmentMapper.deleteByPrimaryKey(attachmentId);
        return SUCCESS;
    }
}
