package com.jpabook.jpashop.Service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // Spring이랑 Integration해서 Test 시도
@SpringBootTest
@Transactional // Default RollBack
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test // Transactional -> 같은 영속성 컨텐츠에서 PK가 같으면 같은 것으로 관리됨
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("kim");
        //when
        Long savedId = memberService.join(member);
        //then
        em.flush(); // Persist에서 변경된 것을 DB에 반영하는 과정
        assertEquals(member, memberRepository.findOne(savedId));
    }
    @Test(expected = IllegalStateException.class) // 이런 예외를 기다리고 있다!
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setUsername("kim1");
        Member member2 = new Member();
        member2.setUsername("kim1");
        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
        fail("예외 발생");

//        //when -> 조금 Code가 긴 예외 확인
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//        } catch(IllegalStateException e) {
//            return;
//        }
//        //then
//        fail("예외가 발생해야 한다");
    }
}