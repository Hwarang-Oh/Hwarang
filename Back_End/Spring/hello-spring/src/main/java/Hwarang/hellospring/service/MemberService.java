package Hwarang.hellospring.service;

import Hwarang.hellospring.domain.Member;
import Hwarang.hellospring.repository.MemberRepository;
import Hwarang.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /*
    * 회원 가입
     */
    public Long join(Member member) {
        // 예) Business Logic : 같은 이름이 있는 중복 회원X
        // getorElse 이런거 많의 쓴다.
        // Optional을 빼서 쓰는 것을 권장하지 않는다.

        long start = System.currentTimeMillis();
        try {
            validateDupMem(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join =  " + timeMs + "ms");
        }
//        validateDupMem(member); // 중복 회원 검증
//        memberRepository.save(member);
//        return member.getId();
    }
    /*
    * 전체 회원 조회
     */

    private void validateDupMem(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMembers() {

        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers =  " + timeMs + "ms");
        }

//        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
