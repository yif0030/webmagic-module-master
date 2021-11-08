package com.webmagic.service.impl;

import com.webmagic.model.InstituteInformation;
import com.webmagic.mapper.InstituteInformationMapper;
import com.webmagic.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
	
	@Autowired
	private InstituteInformationMapper informationMapper;
	
	@Override
	public Integer insert(InstituteInformation information) {
		return null;
	}
	
	@Override
	public Integer delete(InstituteInformation information) {
		return null;
	}
	
	@Override
	public Integer update(InstituteInformation information) {
		return null;
	}
	
	@Override
	public List<InstituteInformation> select(InstituteInformation information) {
		List<InstituteInformation> list = informationMapper.selectAll();
		return list;
	}
	
	@Override
	public InstituteInformation get(Integer id) {
		return null;
	}
}
