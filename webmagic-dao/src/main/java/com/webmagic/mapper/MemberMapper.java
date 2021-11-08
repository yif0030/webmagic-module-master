package com.webmagic.mapper;

import com.webmagic.model.Member;
import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    Member selectByPrimaryKey(String id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);
}