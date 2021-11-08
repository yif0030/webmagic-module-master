package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.NoticeMapper;
import com.webmagic.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知公告
 */
@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeMapper noticeMapper;
    
    @RequestMapping("page")
    public ModelAndView page(){
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
        Notice Notice = noticeMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, Notice);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(){
        
        List<Notice> list = noticeMapper.selectAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 0);
        resultMap.put("message", "");
        resultMap.put("total", list.size());
        Map<String, Object> item = new HashMap<>();
        item.put("item", list);
        resultMap.put("data", item);
        
        return resultMap;
    }
    
    @RequestMapping("add")
    @ResponseBody
    public String add(Notice notice){
        notice.setId(IdWorker.getIdStr());
        notice.setCreateTime(new Date());
        noticeMapper.insert(notice);
        return SUCCESS;
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public String edit(Notice notice){
        notice.setCreateTime(new Date());
        noticeMapper.updateByPrimaryKey(notice);
        return SUCCESS;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        noticeMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
}
