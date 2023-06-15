package hello.hellospring.compentScan.repository;

import hello.hellospring.compentScan.domain.ComponentScanMember;
import java.util.List;
import java.util.Optional;

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

public interface ComponentScanMemberRepository {

    //기능

    ComponentScanMember save(ComponentScanMember componentScanMember);

    //Optional java 8에 들어가있는 문법 -> 공부 바람
    Optional<ComponentScanMember> findById(Long id);

    Optional<ComponentScanMember> findByName(String name);

    List<ComponentScanMember> findAll();


}
