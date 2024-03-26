package com.jpabook.jpashop.Service;

import com.jpabook.jpashop.domain.Delivery;
import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderItem;
import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.ItemRepository;
import com.jpabook.jpashop.repository.MemberRepository;
import com.jpabook.jpashop.repository.OrderRepository;
import com.jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Dictionary;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    // lombok의 강력함

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
//        OrderItem orderItem1 = new OrderItem();
//        ~~~
        // 유지보수가 매우 어려움 -> OrderItem에서 생성을 막아놓을 필요가 있음 -> 생성자 Protected!!

        // 주문 생성
        Order order = Order.CreateOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        // 왜 order만 Repository에 저장한 것일까? -> order -> orderitems, delivery에 Persist날려줌
        // CASCADE를 언제 써야 할것인가? order가 delivery / orderitem을 관리 ( 참조하는 것이 Private 주인일때 -> LifeCycle )
        return order.getId();
    }

    // 주문 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        // 주문 취소
        order.cancel(); // JPA가 아닌, SQL을 직접 다뤄야 하는 Library는, 로직이 끝나면 Update Query를 다시 DB에 보내야 한다!
        // JPA는 변경 감지를 통해, 해당 부분에 대해 Update Queary를 날려서 해결
    }

    // 검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByCriteria(orderSearch);
    }
}
