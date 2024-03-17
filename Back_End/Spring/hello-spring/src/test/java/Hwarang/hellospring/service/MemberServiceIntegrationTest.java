package Hwarang.hellospring.service;

import Hwarang.hellospring.domain.Member;
import Hwarang.hellospring.repository.MemberRepository;
import Hwarang.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // SpringTest 목적
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService; // Spring에서 주입해주는 것을 확인해야 하므로, @Autowired
    @Autowired MemberRepository memberRepository; // test에서는 그냥 필드 주입으로 편하게 해도 된다.
    // MemberRepositroy로 바꿔줘야 한다. MemoryMemberRepository라는 구현체로 하지 않는다.

//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }

//    @AfterEach
//    public void afterEach(){ // 이렇게 초기화 해주는 것은 좋다. (하지만.. )
//        memberRepository.clearStore();
//    } -> 더이상 필요 없는 것들 by @ Transactional

    @Test
    void join() {
        // given -> 어떤 상황이 주어져서
        Member member = new Member();
        member.setName("spring1");
        // when -> 이것을 실행하면
        Long saveId = memberService.join(member);
        // then -> 이와같은 결과가 나타나야 한다!
        // -> 테스트가 쉬워지지 않는다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    // Test -> 예외에 대한 처리가 더 중요함!!
    @Test
    public void dupJoin() {
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring1");

        // when
        // 예외를 try catch로 잡을 수도 있음 => but 번거로움
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
    }
}