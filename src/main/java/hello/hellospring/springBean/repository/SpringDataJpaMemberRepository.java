package hello.hellospring.springBean.repository;

import hello.hellospring.springBean.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : hello.hellospring.springBean.repository
 * fileName       : SpringDataJpaMemberRepository
 * author         : asdfz
 * date           : 2023-06-17
 * description    : 인터페이스는 다중상속 되었었ㅈㅣ...
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-19        asdfz       최초 생성
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,
    MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
