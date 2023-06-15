package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hello.hellospring.compentScan.domain.ComponentScanMember;
import hello.hellospring.compentScan.repository.ComponentScanMemoryMemberRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * packageName    : hello.hellospring.repository
 * fileName       : MemoryMemberRepositoryTest
 * author         : asdfz
 * date           : 2023-06-13
 * description    : 테스트 케이스, 테스트 케이스는 클레스 타입 또는 페키지 단위에서 돌릴 수 도 있음
 * testcase를 먼저 작성을 한다음에 repository를 작성할 수도 있음 ==> tdd라고 함
 * ->
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-13        asdfz       최초 생성
 */
class MemoryComponentScanComponentScanMemberRepositoryTest {

    ComponentScanMemoryMemberRepository repository = new ComponentScanMemoryMemberRepository();

    //하나의 test method가 실행이 끝날때마다 아래 메소드 실행
    @AfterEach
    public void afterEach() {
        //테스트가 끝날때마다 리포지토리 클리어
        //테스트 케이스는 서로 의존관계 없이 설계되어야함
        //그래서 테스트가 끝날때마다 공용 데이터는 지워줘야함
        repository.clearStroe();
    }


    @Test
    void save() {
        //실무에서는 build tool이랑 엮어서 testcase 넘어가지 않으면 종료
        ComponentScanMember componentScanMember = new ComponentScanMember();
        componentScanMember.setName("Spring");

        repository.save(componentScanMember);

        //검증
        ComponentScanMember result = repository.findById(componentScanMember.getId()).get();
        //jupiter 의 Assertions
//        Assertions.assertEquals(member, result);
//        Assertions.assertEquals(member, null);
        //assertEquals(expected, actual)

        //Assertions.assertThat(member).isEqualTo(result); 에서 ctrl+enter 치면 static으로 import
        //org.assertj.core의
        assertThat(componentScanMember).isEqualTo(result);
    }

    @Test
    void findByName() {

        //member 저장
        ComponentScanMember componentScanMember1 = new ComponentScanMember();
        componentScanMember1.setName("Spring1");
        repository.save(componentScanMember1);

        //복사한 다음 변수 클릭 수 shift + F6하면 자동 변경
        ComponentScanMember componentScanMember2 = new ComponentScanMember();
        componentScanMember2.setName("Spring2");
        repository.save(componentScanMember2);

        ComponentScanMember result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(componentScanMember1);

    }

    @Test
    void findAll() {
        //member 저장
        ComponentScanMember componentScanMember1 = new ComponentScanMember();
        componentScanMember1.setName("Spring1");
        repository.save(componentScanMember1);

        ComponentScanMember componentScanMember2 = new ComponentScanMember();
        componentScanMember2.setName("Spring1");
        repository.save(componentScanMember2);

        List<ComponentScanMember> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findById() {
    }


}