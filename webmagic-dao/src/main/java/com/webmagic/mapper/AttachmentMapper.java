package com.webmagic.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.webmagic.model.Attachment;

import java.util.List;

public interface AttachmentMapper extends BaseMapper<Attachment> {
    int deleteByPrimaryKey(String id);

    Integer insert(Attachment record);

    Attachment selectByPrimaryKey(String id);

    List<Attachment> selectAll();

    int updateByPrimaryKey(Attachment record);
    
}