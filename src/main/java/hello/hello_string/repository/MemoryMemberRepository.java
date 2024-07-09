package hello.hello_string.repository;

import hello.hello_string.domain.Member;

import java.util.*;

// 회원 리포지토리 구현체
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // id는 1씩 증가하며, member에 id를 설정한다.
    // store에 id를 키로 하여 value를 저장한다.
    // member를 반환한다
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // store에서 id를 키로 하여 value를 찾는다.
    // null이 반환될 수 있으므로 Optional로 감싸서 반환한다.
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // store의 value를 루프를 돌면서 member의 username과 name이 같은지 하나라도 찾는다.
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getUsername().equals(name))
                .findAny();
    }

    // store의 value를 ArrayList로 반환한다.
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
