package hello.hello_string.service;

import hello.hello_string.domain.Member;
import hello.hello_string.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 테스트를 실행하기 전에 실행되는 메소드
    // MemoryMemberRepository는 MemberService에 의존성 주입(DI)된다.
    // 이렇게 하면 MemberService 입장에서는 MemberRepository의 구현체가 무엇이든 상관없이 동작할 수 있다.
    // 의존성 주입을 통해 모든 테스트에서 같은 인스턴스를 공유하여 사용한다.
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    // 테스트가 끝날 때마다 실행되는 메소드
    // 테스트는 순서에 상관없이 실행되어야 한다.
    // 따라서 테스트가 끝날 때마다 저장소를 비워준다.
    // 이렇게 하면 테스트 간의 의존관계를 없앨 수 있다.
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setUsername("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setUsername("spring");

        Member member2 = new Member();
        member2.setUsername("spring");

        // when
        memberService.join(member1);

        // member2를 join하면 IllegalStateException이 발생해야 한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then

    }

    @Test
    void 전체_회원_조회() {
        // given

        // when

        // then
    }

    @Test
    void 특정_회원_조회() {
        // given

        // when

        // then
    }
}