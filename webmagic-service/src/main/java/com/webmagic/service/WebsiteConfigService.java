package com.webmagic.service;

import com.webmagic.model.WebsiteConfig;

import java.util.List;

public interface WebsiteConfigService {

    Integer insert(WebsiteConfig wc);

    Integer delete(WebsiteConfig wc);

    Integer update(WebsiteConfig wc);

    List<WebsiteConfig> select(WebsiteConfig wc);

    WebsiteConfig get();

    WebsiteConfig get(Integer id);
}
