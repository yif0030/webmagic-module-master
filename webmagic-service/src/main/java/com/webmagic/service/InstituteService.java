package com.webmagic.service;

import com.webmagic.model.Institute;
import com.webmagic.model.User;

import java.util.List;

public interface InstituteService {
	
	Integer insert(Institute institute);
	
	Integer delete(Institute institute);
	
	Integer update(Institute institute);
	
	List<Institute> select(Institute institute);
	
	Institute get(Integer id);
}
