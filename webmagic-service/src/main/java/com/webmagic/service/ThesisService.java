package com.webmagic.service;

import com.webmagic.model.Thesis;
import com.webmagic.model.ThesisAttachment;

import java.util.List;

public interface ThesisService {
    
    /**
     * 查询论文列表
     * @return
     */
    List<ThesisAttachment> queryThesisList(Thesis thesis);
}
