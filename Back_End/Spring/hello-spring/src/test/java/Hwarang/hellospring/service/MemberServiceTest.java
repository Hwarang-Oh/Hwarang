package Hwarang.hellospring.service;

import Hwarang.hellospring.domain.Member;
import Hwarang.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
// 보통 Test Code는 과감하게 한글로 해도 큰 상관 없다!! -> 빌드될때 포함되지도 않음
//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // MemoryMemberRepository() -> new로 다른 객체로 생서오디어 있음. -> 그럴 이유는 없음.
    // 같은 레파시토리로 테스트를 했어야 함.

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    // MemberService 입장에서 보면 외부에서 넣어주고 있음. (DI -> 의존성 주입! )

    @AfterEach
    public void afterEach(){ // 이렇게 초기화 해주는 것은 좋다. (하지만.. )
        memberRepository.clearStore();
    }

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


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}