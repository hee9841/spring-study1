package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.compentScan.domain.ComponentScanMember;
import hello.hellospring.compentScan.repository.ComponentScanMemoryMemberRepository;
import hello.hellospring.compentScan.service.ComponentScanMemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * packageName    : hello.hellospring.service
 * fileName       : MemeberServiceTest
 * author         : asdfz
 * date           : 2023-06-13
 * description    :
 * 테스트는 정상플로우도 중요한데 예외 프로우로가 훨씬 중요함
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
class ComponentScanComponentScanMemberServiceTest {

    /*
        MemeberService memeberService = new MemeberService();
    
        //클리어해주기 위해서
        //애매한게 -> 서비스의 리포지토리가 new 해서 새로운 객체고
        // 여기에서 리포지토리가 new라서 다른 인스턴스임
        // 현재는 리포지토리의 store가 static이라 문제가 안생기지만 만약에 store이 아니면 문제가 생김
        // 그래서 맴버 서비스부분을 변경 (A-1 확인)
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        
        //위에 A-1 변경후 아래 A-2로 변경
     */

    //A-2 (beforeEache로)
    ComponentScanMemberService componentScanMemberService;
    ComponentScanMemoryMemberRepository memberRepository;

    @BeforeEach
    public void befreEaceh() {
        //memberRepository를 만들고, 서비스에 넣에줌
        //-> 같은 리포지토리를 사용함
        // -> 서비스 입장에서는 외부에서 리포지토리를 넣어줌
        // -> 이런거를 dependency injection(DI, 의존관계 주입)
        memberRepository = new ComponentScanMemoryMemberRepository();
        componentScanMemberService = new ComponentScanMemberService(memberRepository);
    }


    @AfterEach
    public void afterEach() {
        memberRepository.clearStroe();

    }


    @DisplayName("회원가입")
    @Test
    void join() {

        //given
        ComponentScanMember componentScanMember = new ComponentScanMember();
        componentScanMember.setName("hello");

        //when
        Long saveId = componentScanMemberService.join(componentScanMember);

        //then
        ComponentScanMember findMeber = componentScanMemberService.findOne(saveId).get();

        assertThat(componentScanMember.getName()).isEqualTo(findMeber.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        ComponentScanMember componentScanMember1 = new ComponentScanMember();
        componentScanMember1.setName("spring");

        ComponentScanMember componentScanMember2 = new ComponentScanMember();
        componentScanMember2.setName("spring");

        //when
        /*
            memeberService.join(member1);
            try {
                memeberService.join(member2);
                //예외 발생 안하면 test 실해
                fail();
            } catch (IllegalStateException e) {
                assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            }
         */

        componentScanMemberService.join(componentScanMember1);
        //try catch 대신 사용가능
        IllegalStateException e = assertThrows(IllegalStateException.class,
            () -> componentScanMemberService.join(componentScanMember2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}