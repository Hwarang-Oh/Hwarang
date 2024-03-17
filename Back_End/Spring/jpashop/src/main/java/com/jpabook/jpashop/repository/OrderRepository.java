package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;
    public void save(Order order) {
        em.persist(order);
    }
    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    // 검색 기능 -> 동적 쿼리가 들어감 ( 마지막에 해야 함 )
//     public List<Order> findAll(OrderSearch orderSearch) {
         // 다 가져오라는 Query -> 해당 조건이 But 없다면? -> 뭐라도 가져와야지..( 동적 쿼리 )
         // 그런거 고려 안하면, 다음과 같이 하면 됨
//        return em.createQuery("select o from Order o join o.member m " +
//                "where o.status = :status and m.username like :name", Order.class)
//                .setParameter("status",orderSearch.getOrderStatus())
//                .setParameter("name",orderSearch.getMemberName())
//                .setMaxResults(1000) // Paging
//                .getResultList();


         // JPQL 이용 -> 매우 지옥 ( 실무에서 이렇게 하지 않는다 )
         // 그래서 동적 쿼리의 이점을 위해 MyBatis를 사용하는 경우 많음
//         String jpql = "select o From Order o join o.member m";
//         boolean isFirstCondition = true;
//
//         if (orderSearch.getOrderStatus() != null) {
//             if (isFirstCondition) {
//                 jpql += " where";
//                 isFirstCondition = false;
//             }
//             else {
//                 jpql += " and";
//             }
//             jpql += " o.status = :status";
//         }
//         .
//         .
//         .

         // JPA Criteria로 처리 -> 표준스펙이니까 소개한 것
    // 도저히 모든 JPQL이 만들어지는 지 감이 안옴.
    // Querydsl이 제시한 해결책이 가장 맛도리
     public List<Order> findAllByCriteria(OrderSearch orderSearch) {
         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<Order> cq = cb.createQuery(Order.class);
         Root<Order> o = cq.from(Order.class);
         Join<Order, Member> m = o.join("member", JoinType.INNER); //회원과 조인
         List<Predicate> criteria = new ArrayList<>();
         //주문 상태 검색
         if (orderSearch.getOrderStatus() != null) {
             Predicate status = cb.equal(o.get("status"),
                     orderSearch.getOrderStatus());
             criteria.add(status);
         }
         //회원 이름 검색
         if (StringUtils.hasText(orderSearch.getMemberName())) {
             Predicate name =
                     cb.like(m.<String>get("name"), "%" + orderSearch.getMemberName()
                             + "%");
             criteria.add(name);
         }
         cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
         TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
         //최대 1000건
         return query.getResultList();
    }

    // Querydsl-> 어떤 JPQL이 생성될건지 파악 가능 -> 매우 강력한 기능
//    public List<Order> findAll(OrderSearch orderSearch) {
//        QOrder order = QOrder.order;
//        QMember member = QMember.member;
//
//        return query
//                .select(order)
//                .from(order)
//                .join(order.member, member)
//                .where(statusEq(orderSearch.getOrderStatus()),
//                        nameLike(orderSearch.getMemberName()))
//                .limit(1000)
//                .fetch();
//    }
}
