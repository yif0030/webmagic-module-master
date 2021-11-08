package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.admin.vo.ScientificResearchProjectVO;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.PageIntroduceMapper;
import com.webmagic.mapper.ScientificResearchProjectMapper;
import com.webmagic.model.PageIntroduce;
import com.webmagic.model.ScientificResearchProject;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 科研项目
 */
@Controller
@RequestMapping("srproject")
public class ScientificResearchProjectController extends BaseController {

    @Autowired
    private ScientificResearchProjectMapper srpMapper;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ScientificResearchProject project = srpMapper.selectByPrimaryKey(id);
        
        ScientificResearchProjectVO researchProjectVO = new ScientificResearchProjectVO();
        researchProjectVO.setId(project.getId());
        researchProjectVO.setTitle(project.getTitle());
        researchProjectVO.setContent(project.getContent());
        researchProjectVO.setFromTime(sdf.format(project.getFromTime()));
        researchProjectVO.setToTime(sdf.format(project.getToTime()));
        researchProjectVO.setCreateTime(project.getCreateTime());
        researchProjectVO.setLevel(project.getLevel());
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, researchProjectVO);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(){
        
        List<ScientificResearchProject> list = srpMapper.selectAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<ScientificResearchProjectVO> resultList = new ArrayList<>();
        for (ScientificResearchProject project : list) {
            ScientificResearchProjectVO researchProjectVO = new ScientificResearchProjectVO();
            researchProjectVO.setId(project.getId());
            researchProjectVO.setTitle(project.getTitle());
            researchProjectVO.setContent(project.getContent());
            researchProjectVO.setFromTime(sdf.format(project.getFromTime()));
            researchProjectVO.setToTime(sdf.format(project.getToTime()));
            researchProjectVO.setCreateTime(project.getCreateTime());
            researchProjectVO.setLevel(project.getLevel());
            resultList.add(researchProjectVO);
        }
        
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
    public String add(ScientificResearchProjectVO projectVO){
        
        ScientificResearchProject projectDTO = new ScientificResearchProject();
        projectDTO.setId(IdWorker.getIdStr());
        projectDTO.setTitle(projectVO.getTitle());
        projectDTO.setContent(projectVO.getContent());
        projectDTO.setCreateTime(new Date());
        projectDTO.setLevel(projectVO.getLevel());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            projectDTO.setFromTime(sdf.parse(projectVO.getFromTime()));
            projectDTO.setToTime(sdf.parse(projectVO.getToTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        srpMapper.insert(projectDTO);
        return SUCCESS;
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public String edit(ScientificResearchProjectVO projectVO){
    
        ScientificResearchProject projectDTO = new ScientificResearchProject();
        projectDTO.setId(projectVO.getId());
        projectDTO.setTitle(projectVO.getTitle());
        projectDTO.setContent(projectVO.getContent());
        projectDTO.setCreateTime(new Date());
        projectDTO.setLevel(projectVO.getLevel());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            projectDTO.setFromTime(sdf.parse(projectVO.getFromTime()));
            projectDTO.setToTime(sdf.parse(projectVO.getToTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
        srpMapper.updateByPrimaryKey(projectDTO);
        return SUCCESS;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        srpMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
    @RequestMapping("introduce/edit")
    @ResponseBody
    public String editIntroduce(PageIntroduce introduce) {
        introduceMapper.updateByPrimaryKey(introduce);
        return SUCCESS;
    }
}
