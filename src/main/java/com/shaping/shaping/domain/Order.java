package com.shaping.shaping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "order_table")
@Entity
@Getter
@Setter
public class Order extends BaseEntity {

    // User 구분  Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Embedded
    private Address address;

    private int totalPrice;

    protected Order(){}

    public void add(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void remove(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public static Order createOrder(Member member, List<OrderItem> orderItems){
        Order order = new Order();
        order.setMember(member);
        for (OrderItem orderItem : orderItems) {
            order.totalPrice += orderItem.getTotalPrice();
            order.add(orderItem);
        }
        return order;
    }

    public void couponDiscount(double couponDiscount){

    }


}


