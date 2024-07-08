package com.shaping.shaping.domain;

import com.shaping.shaping.enums.MemberStatus;
import com.shaping.shaping.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Table(name = "member")
@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    // User 구분  Id
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 성함
    private String name;

    // 비밀번호 - 후에 수정할듯
    private String password;

    // 이메일
    private String email;

    private String tel;

    // 0 이면 여자 1 이면 남자
    private boolean sex;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private MemberStatus memberStatus;

    // 주소 추가는 나중에
//    @Embedded
//    private Address address;

    protected Member(){}
    public Member(String name, String password, String email, String tel, boolean sex, RoleType roleType, MemberStatus memberStatus) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.sex = sex;
        this.roleType = roleType;
        this.memberStatus = memberStatus;
    }

}
