package com.shaping.shaping.domain;

import com.shaping.shaping.enums.MemberType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {
    @NotBlank(message = "이메일은 필수 항목입니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    private String password;
    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 항목입니다.")
    private String tel;
    @NotBlank(message = "성별은 필수 항목입니다.")
    private MemberType sex;

    @NotBlank(message = "우편 번호는 필수 항목입니다.")
    private int postcode;

    @NotBlank(message = "도로명 주소는 필수 항목입니다.")
    private String roadAddress;
    @NotBlank(message = "지번 주소는 필수 항목입니다.")
    private String jibunAddress;
    @NotBlank(message = "상세 주소는 필수 항목입니다.")
    private String detailAdd;
}
