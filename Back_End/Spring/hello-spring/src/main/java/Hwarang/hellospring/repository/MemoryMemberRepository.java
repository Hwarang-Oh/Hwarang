package Hwarang.hellospring.repository;

import Hwarang.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    // 공유되는 변수 -> Cocnre hashMap?
    private static long sequence = 0L;
    // 동시성 문제 autom Long?

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // Client단에서 Null에 대한 처리가 가능해짐
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 멤버에서 getName이 param name과 같은지 -> 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        // java의 실무 -> List 많이 이용
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
