package demo;

import org.springframework.stereotype.Component;

/**
 * packageName    : demo
 * fileName       : Demo
 * author         : asdfz
 * date           : 2023-06-15
 * description    : 아무데나 @Compent가 있어도 되는지??
 * 여기서 안됨 -> HelloSpringApplication.java
 * (@SpringBootApplication이 있는 SpringApplication.run이 시작되는?? class의 패키지의 하위 패키지는 등록하지만)
 * 그외의 패키지 현재 demo class는 demo 패키지에 있어서  @Component가 있다고 하더라도 등록이 안됨 (물론 설정하면 되지만 기본족으로 안함)
 * ('@SpringBootApplication 이 있는 패키지는 hello.hellospring임)
 * '@SpringBootApplication 들어가보면 @ComponentScan 이 있음
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Component
public class Demo {

}
