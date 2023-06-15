package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * packageName    : hello.hellospring.repository
 * fileName       : MemoryMemberRepository
 * author         : asdfz
 * date           : 2023-06-13
 * description    : 구현체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-13        asdfz       최초 생성
 */
public class MemoryMemberRepository implements MemberRepository {


    //임시 저장을 위해
    // 공유되는 변수일 때는 동시성문제가 있어서 ConcurrentHashMap을 사용
    private static Map<Long, Member> store = new HashMap<>();
    // 공유되는 변수일 때는 동시성문제가 있어서 AtomicLong 사용
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 Optional로 감싸서 반황를 해주면
        // null이여도 반환 가능
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //findAny는 하나라도 있으면 반환
        return store.values().stream()
            .filter(member -> member.getName().equals(name))
            .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStroe() {
        store.clear();
    }

}
