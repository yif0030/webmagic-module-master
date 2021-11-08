package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.webmagic.model.Institute;
import com.webmagic.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("institute")
public class InstituteController extends BaseController {
	
	@Autowired
	private InstituteService instituteService;
	
	@RequestMapping("update")
    @ResponseBody
	public Map<String, String> update(String intruductionStr) {
		
		Institute institute = new Institute();
		institute.setId(0);
		institute.setIntroduction(intruductionStr);
		instituteService.update(institute);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put(RESULT, SUCCESS);
		return resultMap;
	}
}
