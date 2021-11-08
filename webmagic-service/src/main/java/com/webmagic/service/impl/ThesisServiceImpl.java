package com.webmagic.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.webmagic.mapper.AttachmentMapper;
import com.webmagic.mapper.ThesisMapper;
import com.webmagic.model.Attachment;
import com.webmagic.model.Thesis;
import com.webmagic.model.ThesisAttachment;
import com.webmagic.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ThesisServiceImpl implements ThesisService {
    @Autowired
    private ThesisMapper thesisMapper;
    @Autowired
    private AttachmentMapper attachmentMapper;
    @Override
    public List<ThesisAttachment> queryThesisList(Thesis param) {
        List<ThesisAttachment> resultList = new ArrayList<>();
        List<Thesis> list = thesisMapper.selectAll();
        for (Thesis thesis : list) {
            ThesisAttachment thesisAttachment = new ThesisAttachment();
            thesisAttachment.setId(thesis.getId());
            thesisAttachment.setTitle(thesis.getTitle());
            thesisAttachment.setType(thesis.getType());
            thesisAttachment.setYear(thesis.getYear());
            thesisAttachment.setCreateTime(thesis.getCreateTime());
            String thesisId = thesis.getId();
            EntityWrapper<Attachment> wrapper = new EntityWrapper<>();
            wrapper.where("foreign_id={0}", thesisId);
            List<Attachment> attachmentList = attachmentMapper.selectList(wrapper);
            thesisAttachment.setAttachmentList(attachmentList);
            resultList.add(thesisAttachment);
        }
        return resultList;
    }
}
