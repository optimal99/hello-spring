package hello.hello_string.service;

import hello.hello_string.domain.Member;
import hello.hello_string.repository.MemberRepository;
import hello.hello_string.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 서비스의 역할에 맞게 네이밍을 해준다.
public class MemberService {
    private final MemberRepository memberRepository;

    // Dependency Injection(DI) : 외부에서 Repository를 주입받는다.
    // MemberRepository를 외부에서 주입받도록 변경.
    // 이렇게 하면 MemberService 입장에서는 MemberRepository의 구현체가 무엇이든 상관없이 동작할 수 있다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    // 같은 이름이 있는 중복 회원X
    // findByName의 반환형이 Optional 이기에  ifPresent를 사용할 수 있다.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getUsername())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
     * 특정 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
