package com.shaping.shaping.domain;

import com.shaping.shaping.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "item")
@Entity
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 아이템 유형
    private int itemType;

    // 상품명
    private String itemName;

    // 가격
    private int price;
    // 수량
    private int stock;

    private double disCount = 0.0;

    // SELL SOLD_OUT
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
}
