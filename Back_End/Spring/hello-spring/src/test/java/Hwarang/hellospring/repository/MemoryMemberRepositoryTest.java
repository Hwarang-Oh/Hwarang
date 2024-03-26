package Hwarang.hellospring.repository;

import Hwarang.hellospring.domain.Member;
import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    // M

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
        // Setting된 아이디가 잘 되어 있는가?
        // 하나하나 이걸 다 확인하는 것은 웃김
        Assertions.assertEquals(member, result); //
        // + 조금 더 편한 방법이 존재
        assertThat(member).isEqualTo(result);
        // 조금 더 비교 방향이 괜찮음
        // 또한 static Import로도 가능함
        // Assertions.asserThat(member).isEqualTo(result);
        // Build Tool에서 통과하지 못하면, 다음 단계로 못가는 그런 느낌
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
        // 안맞으면 다른 객체라는 오류가 뜸
        // Class 레벨에서도 테스트가 가능하다.
        // 여러개의 Test를 진행할 수 있다는 뜻이다.
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
