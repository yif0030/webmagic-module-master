package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.admin.vo.ScientificResearchProjectVO;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.AdmissionMapper;
import com.webmagic.mapper.CourseTeachMapper;
import com.webmagic.mapper.PageIntroduceMapper;
import com.webmagic.mapper.ScientificResearchProjectMapper;
import com.webmagic.model.CourseTeach;
import com.webmagic.model.PageIntroduce;
import com.webmagic.model.ScientificResearchProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 课程教学
 */
@Controller
@RequestMapping("courseteach")
public class CourseTeachController extends BaseController {
    
    @Autowired
    private CourseTeachMapper courseTeachMapper;
    @Autowired
    private PageIntroduceMapper introduceMapper;
    
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
        CourseTeach courseTeach = courseTeachMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, courseTeach);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(){
        
        List<CourseTeach> list = courseTeachMapper.selectAll();
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
    @ResponseBody
    public String add(CourseTeach courseTeach){
        courseTeach.setId(IdWorker.getIdStr());
        courseTeach.setCreateTime(new Date());
        courseTeachMapper.insert(courseTeach);
        return SUCCESS;
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public String edit(CourseTeach courseTeach){
        courseTeachMapper.updateByPrimaryKey(courseTeach);
        return SUCCESS;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        courseTeachMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
    @RequestMapping("introduce/edit")
    @ResponseBody
    public String editIntroduce(PageIntroduce introduce) {
        introduceMapper.updateByPrimaryKey(introduce);
        return SUCCESS;
    }
}
