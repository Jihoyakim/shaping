package com.shaping.shaping.mapper;

import com.shaping.shaping.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findById(Long id);

    void addMember(Member member);
}
