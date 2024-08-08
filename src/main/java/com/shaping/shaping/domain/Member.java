package com.shaping.shaping.domain;

import com.shaping.shaping.enums.MemberStatus;
import com.shaping.shaping.enums.MemberType;
import com.shaping.shaping.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "member")
@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    // User 구분  Id
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 성함
    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;

    // 비밀번호 - 후에 수정할듯
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String password;

    // 이메일
    @Column(unique = true)
    @NotBlank(message = "이메일은 필수 항목입니다.")
    private String email;

    @NotBlank(message = "전화번호는 필수 항목입니다.")
    private String tel;

    // 0 이면 여자 1 이면 남자
    @Enumerated(EnumType.STRING)
    @NotNull(message = "성별은 필수 항목입니다.")
    private MemberType sex;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Embedded
    @NotNull(message = "주소는 필수 항목입니다.")
    private Address address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberCoupon> memberCoupons = new ArrayList<>();
    protected Member(){}
    public Member(String name, String password, String email, String tel, MemberType sex, RoleType roleType, MemberStatus memberStatus, Address address) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.sex = sex;
        this.roleType = roleType;
        this.memberStatus = memberStatus;
        this.address = address;
    }
    public Member (MemberDto memberDto , RoleType roleType, MemberStatus memberStatus){
        this.email = memberDto.getEmail();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
        this.tel = memberDto.getTel();
        this.sex = memberDto.getSex();
        this.roleType = roleType;
        this.memberStatus = memberStatus;
        Address address = new Address(memberDto.getPostcode(),memberDto.getRoadAddress(),memberDto.getJibunAddress(),memberDto.getDetailAdd());
        this.address = address;
    }

}
