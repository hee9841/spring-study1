package hello.hellospring.springBean.repository;

import hello.hellospring.springBean.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : hello.hellospring.springBean.repository
 * fileName       : JpaMemberRepository
 * author         : asdfz
 * date           : 2023-06-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-17        asdfz       최초 생성
 */
public class JpaMemberRepository implements MemberRepository {


    private final EntityManager em;

    //트렌젝션 테스트를 위해서(강의X)
    private EntityTransaction tr;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    private void getTr() {
        this.tr = this.em.getTransaction();
    }


    //@Transactional
    @Override
    @Transactional
    public Member save(Member member) {

        em.persist(member);
        return member;

    }


    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //jpqa라는 객체지향 쿼리
        //tabel 단위로 쿼리를 날리는게 아니라
        //객체(엔티티)를 대사으로 쿼리를 날림
        List<Member> result = em.createQuery("select m from Member  m where m.name = :name",
                Member.class)
            .setParameter("name", name)
            .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //select m -> Member라는 객체 자체를 select
        return em.createQuery("select m from Member m", Member.class)
            .getResultList();
    }
}
