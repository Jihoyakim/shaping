package com.shaping.shaping.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private final String value;
}
