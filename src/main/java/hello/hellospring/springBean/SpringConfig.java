package hello.hellospring.springBean;

import hello.hellospring.springBean.repository.JdbcTemplateMemberRepository;
import hello.hellospring.springBean.repository.MemberRepository;
import hello.hellospring.springBean.service.MemberService;
import javax.sql.DataSource;
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


    private DataSource dataSource;


    @Bean
    public MemberService mberService() {
        return new MemberService(memberRepository());
    }


    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

        //jdbc tamplate 방식
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
