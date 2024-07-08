package com.shaping.shaping.domain;

import com.shaping.shaping.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;

@Table(name = "item")
@Entity
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품명
    private String itemName;

    // 가격
    private int price;
    // 수량
    private int stock;
    // SELL SOLD_OUT
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
}
