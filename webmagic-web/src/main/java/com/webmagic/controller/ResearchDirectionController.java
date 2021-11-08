package com.webmagic.controller;

import com.webmagic.controller.base.BaseController;
import com.webmagic.mapper.PageIntroduceMapper;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.PageIntroduce;
import com.webmagic.model.ResearchDirection;
import com.webmagic.mapper.ResearchDirectionMapper;
import com.webmagic.model.WebsiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-10-02
 */
@Controller
@RequestMapping("research")
public class ResearchDirectionController extends BaseController {

    @Autowired
    private ResearchDirectionMapper rdMapper;
    @Autowired
    private PageIntroduceMapper introduceMapper;
    @Autowired
    private WebsiteConfigMapper websiteConfigMapper;

	@RequestMapping("direction")
	public ModelAndView index() {
        WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
        PageIntroduce pageIntroduce = introduceMapper.selectByPrimaryKey("1");
        List<ResearchDirection> list = rdMapper.selectAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject(RESULT, SUCCESS);
        mv.addObject(LIST, list);
        mv.addObject(ENTITY, wc);
        mv.addObject("pageIntroduce", pageIntroduce);
        return mv;
	}


}
