package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * packageName    : hello.hellospring.repository
 * fileName       : MemberRepository
 * author         : asdfz
 * date           : 2023-06-13
 * description    : 이터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-13        asdfz       최초 생성
 */
@Repository
public interface MemberRepository {

    //기능

    Member save(Member member);

    //Optional java 8에 들어가있는 문법 -> 공부 바람
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();


}
