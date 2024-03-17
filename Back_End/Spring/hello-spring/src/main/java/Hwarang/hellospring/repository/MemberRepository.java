package Hwarang.hellospring.repository;

import Hwarang.hellospring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // Java 8에 들어간 기능 :
    List<Member> findAll();
}
