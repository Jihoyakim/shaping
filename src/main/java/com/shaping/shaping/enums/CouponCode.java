package com.shaping.shaping.enums;

import lombok.Getter;

@Getter
public enum CouponCode {
    회원가입쿠폰("001"),
    두번째쿠폰("002"),
    세번째쿠폰("003");

    private final String value;

    CouponCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CouponCode fromValue(String inputValue) {
        for (CouponCode code : CouponCode.values()) {
            if (code.getValue().equals(inputValue)) {
                return code;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + inputValue);
    }
}