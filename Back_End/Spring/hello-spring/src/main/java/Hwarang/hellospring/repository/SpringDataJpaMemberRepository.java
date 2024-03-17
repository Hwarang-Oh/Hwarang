package Hwarang.hellospring.repository;

import Hwarang.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 extends하고 있다면, 자동으로 Spring Bean에 구현체를 만들어서 등록을 해준다.
public interface SpringDataJpaMemberRepository
        extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
