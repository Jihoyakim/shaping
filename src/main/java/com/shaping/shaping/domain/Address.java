package com.shaping.shaping.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private int postcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAdd;

    protected Address() {
    }

    public Address(int postcode, String roadAddress, String jibunAddress, String detailAdd) {
        this.postcode = postcode;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.detailAdd = detailAdd;
    }
}
