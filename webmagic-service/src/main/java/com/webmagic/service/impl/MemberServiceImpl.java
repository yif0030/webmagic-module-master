package com.webmagic.service.impl;

import com.webmagic.mapper.MemberMapper;
import com.webmagic.model.Member;
import com.webmagic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Integer insert(Member member) {
        return null;
    }

    @Override
    public Integer delete(Member member) {
        return null;
    }

    @Override
    public Integer update(Member member) {
        return null;
    }

    @Override
    public List<Member> select(Member member) {
        return null;
    }

    @Override
    public Member get(Integer id) {
        return null;
    }
}
