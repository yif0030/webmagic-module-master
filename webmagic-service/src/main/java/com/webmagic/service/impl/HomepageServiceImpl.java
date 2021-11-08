package com.webmagic.service.impl;

import com.webmagic.model.Homepage;
import com.webmagic.mapper.HomepageMapper;
import com.webmagic.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements HomepageService {
	@Autowired
	private HomepageMapper homepageMapper;
	@Override
	public Integer insert(Homepage homepage) {
		return null;
	}
	
	@Override
	public Integer delete(Homepage homepage) {
		return null;
	}
	
	@Override
	public Integer update(Homepage homepage) {
		return null;
	}
	
	@Override
	public Homepage get(Integer id) {
//		return homepageMapper.selectByPrimaryKey(0);
		return null;
	}
}
