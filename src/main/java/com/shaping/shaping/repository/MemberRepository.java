package com.shaping.shaping.repository;

import com.shaping.shaping.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberById(Long id);
}
