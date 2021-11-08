package com.webmagic.service.impl;

import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.WebsiteConfig;
import com.webmagic.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteConfigServiceImpl implements WebsiteConfigService {
    @Autowired
    private WebsiteConfigMapper websiteConfigMapper;

    @Override
    public Integer insert(WebsiteConfig websiteConfig) {
        return websiteConfigMapper.insert(websiteConfig);
    }

    @Override
    public Integer delete(WebsiteConfig var) {
        return websiteConfigMapper.deleteByPrimaryKey(var.getId());
    }

    @Override
    public Integer update(WebsiteConfig var) {
        return websiteConfigMapper.updateByPrimaryKey(var);
    }

    @Override
    public List<WebsiteConfig> select(WebsiteConfig var) {
        return null;
    }

    @Override
    public WebsiteConfig get() {
        return websiteConfigMapper.selectByPrimaryKey(0);
    }

    @Override
    public WebsiteConfig get(Integer id) {
        return websiteConfigMapper.selectByPrimaryKey(id);
    }
}
