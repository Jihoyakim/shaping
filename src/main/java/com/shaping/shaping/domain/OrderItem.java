package com.shaping.shaping.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long itemId;

    private int itemPrice;

    private int itemCount;

    private int totalPrice;

    private int salePrice;

    private double itemDiscount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderItem(){}
    public OrderItem(Item item, int itemCount, Order order) {
        this.itemId = item.getId();
        this.itemPrice = item.getPrice();
        this.itemCount = itemCount;
        this.itemDiscount = item.getDisCount();
        this.salePrice = (int)(itemPrice * (1 - itemDiscount));
        this.totalPrice = this.salePrice * this.itemCount;
        this.setOrder(order);
    }

    public void init(double itemDiscount){
        this.salePrice = (int)(itemPrice * (1 - itemDiscount));
        this.totalPrice = this.salePrice * this.itemCount;
    }

}
