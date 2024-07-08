package com.shaping.shaping.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "member")
@Entity
@Getter
@Setter
public class Member {

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
    
    // 등록 시간
    private LocalDateTime reg_dt;
    // 업데이트 시간
    private LocalDateTime upd_dt;

    // 주소 추가는 나중에
//    @Embedded
//    private Address address;

    protected Member(){};
    public Member(String name, String password, String email, String tel, boolean sex) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.sex = sex;
        this.reg_dt = LocalDateTime.now();
        this.upd_dt = LocalDateTime.now();
    }
}
