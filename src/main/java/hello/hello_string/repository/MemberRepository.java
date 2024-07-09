package hello.hello_string.repository;

import hello.hello_string.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 리포지토리 인터페이스
public interface MemberRepository {
    Member save(Member member);

    // Optional: null을 처리하는 방법 중 하나로, null을 직접 다루지 않고 Optional로 감싸서 반환한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    List<Member> findAll();
}
