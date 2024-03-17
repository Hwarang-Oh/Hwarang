package Hwarang.hellospring.repository;

import Hwarang.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    // JPA의 모든 Query와 DB 통신을 EntityManager가 담당함
    // 해당 객체 역시, Spring Boot가 Config를 통해, Container에 담고 있다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // Insert Query 만들고 DB에 집어놓고, SetID까지 다 해놓은 상태
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { // PK가 아닌 Key 조회
//        JPQL : 객체 지향 쿼리 (-> 객체를 대상으로 검색을 하는 것이다.)
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class) // JPQ
                .getResultList();
    }
}
