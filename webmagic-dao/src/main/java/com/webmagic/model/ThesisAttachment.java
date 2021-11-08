package com.webmagic.model;

import java.util.Date;
import java.util.List;

public class ThesisAttachment {
    private String id;
    
    private String title;
    
    private String year;
    
    private String type;
    
    private Date createTime;
    
    private List<Attachment> attachmentList;
    
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
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }
    
    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
