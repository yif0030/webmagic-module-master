package com.webmagic.service;

import com.webmagic.model.Institute;
import com.webmagic.model.InstituteInformation;

import java.util.List;

public interface InformationService {
	
	Integer insert(InstituteInformation information);
	
	Integer delete(InstituteInformation information);
	
	Integer update(InstituteInformation information);
	
	List<InstituteInformation> select(InstituteInformation information);
	
	InstituteInformation get(Integer id);
}
