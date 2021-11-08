package com.webmagic.model;

import java.util.Date;

public class ScientificResearchProject {
    private String id;
    
    private String title;
    
    private String content;
    
    private Date fromTime;
    
    private Date toTime;
    
    private String level;
    
    private Date createTime;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getFromTime() {
        return fromTime;
    }
    
    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }
    
    public Date getToTime() {
        return toTime;
    }
    
    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}