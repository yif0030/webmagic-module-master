package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.admin.vo.ScientificResearchProjectVO;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.DataAndCodeMapper;
import com.webmagic.mapper.PageIntroduceMapper;
import com.webmagic.mapper.ScientificResearchProjectMapper;
import com.webmagic.model.DataAndCode;
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
 * 数据与代码(代码)
 */
@Controller
@RequestMapping("datacode/code")
public class DCCodeController extends BaseController {
    
    @Autowired
    private DataAndCodeMapper dataCodeMapper;
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
        DataAndCode dataCode = dataCodeMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, dataCode);
        return mv;
    }
    
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(){
        
        List<DataAndCode> list = dataCodeMapper.selectAll();
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
    public String add(DataAndCode dataCode){
        dataCode.setId(IdWorker.getIdStr());
        dataCode.setCreateTime(new Date());
        dataCode.setType("代码");

        dataCodeMapper.insert(dataCode);
        return SUCCESS;
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public String edit(DataAndCode dataCode){
        dataCodeMapper.updateByPrimaryKey(dataCode);
        return SUCCESS;
    }
    
    @RequestMapping("del")
    @ResponseBody
    public String delInfo(String id) {
        dataCodeMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
    
    @RequestMapping("introduce/edit")
    @ResponseBody
    public String editIntroduce(PageIntroduce introduce) {
        introduceMapper.updateByPrimaryKey(introduce);
        return SUCCESS;
    }
}
