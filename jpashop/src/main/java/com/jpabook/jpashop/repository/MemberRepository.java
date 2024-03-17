package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // Component Scan
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext // Spring이 매니저 만들어서 주입해줌, JPA Entity Manger를 주입받을 수 있음
//    private EntityManager em;
    // -> @PersistenceContext -> @AutoWired로 처리 가능 In SpringBoot, Sprin Data JPA

//    @PersistenceUnit
//    private EntityManagerFactory -> 직접 주입하고 싶을때

//    @Autowired
//    private EntityManager em;
//
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    } -> 이게 되므로, 롬복 적용 가능

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) { // find( type, pk )
        return em.find(Member.class, id);
    }

    public List<Member> findAll() { // from의 대상이 table이 아닌 객체
        return em.createQuery("select m from Member  m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.username = :name", Member.class)
                .setParameter("name", name) // paramet set wiht ":name"
                .getResultList();
    }

    // SQL은 Table에 대한 Query
    // JPQL은 객체에 대한 Query를 날린다고 볼 수 있음.
}
