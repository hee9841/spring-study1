package hello.hellospring.springBean;

import hello.hellospring.springBean.repository.MemberRepository;
import hello.hellospring.springBean.repository.MemoryMemberRepository;
import hello.hellospring.springBean.service.MemberService;
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


    @Bean
    public MemberService mberService() {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
