package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.springBean.domain.Member;
import hello.hellospring.springBean.repository.MemberRepository;
import hello.hellospring.springBean.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : hello.hellospring.service
 * fileName       : MemberServiceIntegrationTest
 * author         : asdfz
 * date           : 2023-06-15
 * description    : 스프링 관련되어서 서비스 통합 테스트
 * '@Transactional를 달면
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-17        asdfz       최초 생성
 */
@SpringBootTest
//test가 완료 되면 rollback
@Transactional
public class MemberServiceIntegrationTest {


    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    
    /* 
        필요 없어짐, 테스트 케이스에서는 중복으로 사용하게 되는 그런거 신경??안써도 되어
        @Autowired 사용하면 됨??
        @BeforeEach
        public void befreEaceh() {
            memberRepository = new ComponentScanMemoryMemberRepository();
            memberService = new memberService(memberRepository);
        }
    
     */

    /*
        이아이도 이제 클리어 할 필요 없어짐(DB연결되어있음)
        @AfterEach
        public void afterEach() {
            memberRepository.clearStroe();
    
        }
        
     */

    @DisplayName("회원가입")
    @Test
    void join() {

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMeber = memberService.findOne(saveId).get();

        assertThat(member.getName()).isEqualTo(findMeber.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        //try catch 대신 사용가능
        IllegalStateException e = assertThrows(IllegalStateException.class,
            () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }


}

