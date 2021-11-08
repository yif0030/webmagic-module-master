package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.ScientificResearchProject;
import com.webmagic.mapper.ScientificResearchProjectMapper;
import com.webmagic.model.WebsiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科研项目
 */
@Controller
@RequestMapping("project")
public class ScientificResearchProjectController extends BaseController {

    @Autowired
    private ScientificResearchProjectMapper srpMapper;
    @Autowired
    private WebsiteConfigMapper websiteConfigMapper;

    @RequestMapping("page")
    public ModelAndView page(HttpServletRequest request, ModelAndView mv) {
        
        List<ScientificResearchProject> list = srpMapper.selectAll();
        List<ScientificResearchProject> tempList_p = new ArrayList();
        List<ScientificResearchProject> tempList_c = new ArrayList();
        List<ScientificResearchProject> tempList_s = new ArrayList();
        for (ScientificResearchProject project : list) {
            String level = project.getLevel();
            if ("省级".equals(level)) {
                tempList_p.add(project);
                continue;
            }
            if ("市级".equals(level)) {
                tempList_c.add(project);
                continue;
            }
            if ("校级".equals(level)) {
                tempList_s.add(project);
                continue;
            }
        }
        
        mv.addObject(RESULT, SUCCESS);
        mv.addObject("province", tempList_p);
        mv.addObject("city", tempList_c);
        mv.addObject("school", tempList_s);


        WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
        mv.addObject(ENTITY, wc);
        return mv;
    }
}
