package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : hello.hellospring.service
 * fileName       : MemeberService
 * author         : asdfz
 * date           : 2023-06-13
 * description    : 회원 서비스
 * <p>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    
    
    /*
        A-1.
         private final MemberRepository memberRepository = new MemoryMemberRepository();
         여기를 아래와 같이 변경
         
        //직접 new해서 생성하는게 아니라
        //외부에서 넣어주도록 변경
        private final MemberRepository memberRepository;
        public MemeberService(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }
         
     */

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //규칙 1. 같은이름이 있는 중복회원은X
        
        /*
            추가적으로 아래주석과 같이 하면 안예뻐서??
            밑에와 같이 사용

            Optional<Member> result = memberRepository.findByName(member.getName());

            result.ifPresent(m -> {
                //과거에는 if null로 하였지만
                //Optional롤 감싸서 처리하면 됨(Optional 여러 메소드 활용)
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
            //추가저으로 orelseget같은것도 많이 사용
         */

        /*
            // Shift+Ctrl+Alt+T 하면 여러가지 리팩토리 관련된게 나옴
            //아래는 extract method( 단독 단축키는 Ctrl+Alt + M)를 사용하여 메소드 추출
             memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
         */

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
