package com.webmagic.service;

import com.webmagic.model.Homepage;

public interface HomepageService {
	
	Integer insert(Homepage homepage);
	
	Integer delete(Homepage homepage);
	
	Integer update(Homepage homepage);
	
	Homepage get(Integer id);
}
