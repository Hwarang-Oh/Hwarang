package com.jpabook.jpashop.Service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // data의 변경과 같은 것은 Transaction이 요구됨 -> spring 제공 or jakarta => Spring
//@AllArgsConstructor // -> 롬복 생성자 Injection을 만들어주는 것!!
@RequiredArgsConstructor // final 있는 field만 가지고, 생성자 Injection을 만들어주는 것!!
public class MemberService {

//    @Autowired // Spring Bean에 있는 것을 Injection! -> field Injection의 단점
//    private MemberRepository memberRepository;

//    @Autowired -> 동작하는 도중에 바꿀 이유 X -> Setter Injection 대신 생성자 Injection
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    private final MemberRepository memberRepository;
//    @Autowired // 생성자에서 Injection을 해주는 것 -> 중간에 set해서 바꾸는 경우 X
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    } // 1개의 생성자만 존재하면 AutoWired 생략 가능하다

    private final MemberRepository memberRepository;


    //회원 가입
    /*
    * 중복 회원 X
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member memeber) {
        // Exception
        List<Member> findMembers = memberRepository.findByName(memeber.getUsername());
        if (!findMembers.isEmpty()) throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
    // Member 이름이 같은 사람 2명이 회원가입하게 되면 -> Multi thread 상황 고려해 -> Unique

    //회원 전체 조회 -> 읽는 것에 대한 최적화!
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
