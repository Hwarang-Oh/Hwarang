package com.jpabook.jpashop.domain.item;

import com.jpabook.jpashop.domain.Category;
import com.jpabook.jpashop.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype") // 구분자
@Getter @Setter
public abstract class Item { // 추상클래스로 만들기, 상속관계 Mapping 요구됨
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비즈니스 로직 -> 재고 관리 -> 이런 로직은 Entity 안에 있는 것이 가장 좋은 설계 /
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int resultStock = this.stockQuantity - quantity;
        if (resultStock < 0) throw new NotEnoughStockException("NEED MORE STOCK");
        this.stockQuantity = resultStock;
    }
}
// Mapping이 발전 불가 그냥 다대다로 연결만 하면!!
