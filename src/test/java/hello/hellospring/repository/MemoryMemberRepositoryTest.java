package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hello.hellospring.domain.Member;
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
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

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
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        //검증
        Member result = repository.findById(member.getId()).get();
        //jupiter 의 Assertions
//        Assertions.assertEquals(member, result);
//        Assertions.assertEquals(member, null);
        //assertEquals(expected, actual)

        //Assertions.assertThat(member).isEqualTo(result); 에서 ctrl+enter 치면 static으로 import
        //org.assertj.core의
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {

        //member 저장
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        //복사한 다음 변수 클릭 수 shift + F6하면 자동 변경
        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll() {
        //member 저장
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findById() {
    }


}