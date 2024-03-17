package com.jpabook.jpashop.domain;

import com.jpabook.jpashop.domain.item.Item;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 제약적인 설계가 더 좋은 설계로 이어질 것
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private  int count;

    // 생성 메서드 //
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

//    protected OrderItem() { -> lombok으로 줄이기 가능
//
//    }


    // == 비즈니스 로직 == //
    public void cancel() {
        getItem().addStock(count);
    }

    // = 조회 로직 = //
    public int getTotalPrice() {
        return getOrderPrice() * count;
    }
}
