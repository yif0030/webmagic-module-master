package com.webmagic.service.impl;

import com.webmagic.model.Institute;
import com.webmagic.model.User;
import com.webmagic.mapper.InstituteMapper;
import com.webmagic.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstituteServiceImpl implements InstituteService {
	
	@Autowired
	private InstituteMapper instituteMapper;
	@Override
	public Integer insert(Institute institute) {
		return null;
	}
	
	@Override
	public Integer delete(Institute institute) {
		return null;
	}
	
	@Override
	public Integer update(Institute institute) {
		return instituteMapper.updateByPrimaryKey(institute);
	}
	
	@Override
	public List<Institute> select(Institute institute) {
		return null;
	}
	
	@Override
	public Institute get(Integer id) {
		return instituteMapper.selectByPrimaryKey(id);
	}
}
