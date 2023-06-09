package hello.hellospring.springBean;

import hello.hellospring.springBean.repository.MemberRepository;
import hello.hellospring.springBean.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : hello.hellospring.springBean
 * fileName       : SpringConfig
 * author         : asdfz
 * date           : 2023-06-15
 * description    : 스프링 Bean 직접등록하는 파일
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Configuration
public class SpringConfig {


    /*
        //jdbc 관련 리포지토리 사용 할 떄
        private DataSource dataSource;

        //jdbc 관련 리포지토리 사용 할 때
        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }
     */

    /*
        //jpa 관련 리포지토리 사용할 때
        //@PersistenceContext
        private EntityManager em;

        //Could not autowire. No beans of 'EntityManager' type found.
        //해당 에러가 나지만, IntelliJ 와 spring boot 사이의 버전 관련해서 생기는 IntelliJ 오류라서
        //잘 돌아가면 무시해도 상관 없음
        @Autowired
        public SpringConfig(EntityManager em) {
            this.em = em;
        }

     */

    //spring jpa data
    private final MemberRepository memberRepository;

    //spring jpa data
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
         /* 다른 방식들
                 return new MemberService(memberRepository());
          */
        return new MemberService(memberRepository);

    }

    //AOP
//    @Bean
//    public TimeTraceAop TimeTraceAop() {
//        return new TimeTraceAop();
//    }


     /*
            spring jpa data 제외 다른 방식들
         @Bean
        public MemberRepository memberRepository() {
            /*
                componentScan방식, 메모리 방식
                return new MemoryMemberRepository();

             */
            /*
                //jdbc 방식
                return new JdbcMemberRepository(dataSource);
             */

            /*
                //jdbc tamplate 방식
                return new JdbcTemplateMemberRepository(dataSource);
             */

            /*
                //JPA 방식
                 return new JpaMemberRepository(em);
             */

    //}  */


}
