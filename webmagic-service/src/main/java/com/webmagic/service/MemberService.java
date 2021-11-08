package com.webmagic.service;

import com.webmagic.model.Member;

import java.util.List;

public interface MemberService {
    Integer insert(Member member);

    Integer delete(Member member);

    Integer update(Member member);

    List<Member> select(Member member);

    Member get(Integer id);
}
