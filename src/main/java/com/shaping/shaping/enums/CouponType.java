package com.shaping.shaping.enums;

import lombok.Getter;

@Getter
public enum CouponType {
    정액(true),       // true로 매핑
    정률(false);  // false로 매핑

    private final boolean value;

    CouponType(final boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public static CouponType fromValue(boolean value) {
        for (CouponType type : CouponType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
