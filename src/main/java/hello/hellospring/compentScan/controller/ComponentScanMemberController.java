package hello.hellospring.compentScan.controller;

import hello.hellospring.compentScan.service.ComponentScanMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * packageName    : hello.hellospring.controller
 * fileName       : MemberController
 * author         : asdfz
 * date           : 2023-06-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Controller
public class ComponentScanMemberController {
    //처음에 spring이 작동할 떄
    //스프링 컨테이너에서 컨트롤러 어노테이션이 있으면
    //해당 객체를 생성해서 넣어두고 스프링에서 관리 함
    // -> 이런걸 스프링 컨테이너에서 스프링빈이 관리된다고 함
    //이 부분이 pdf 15페이지 "MVC, 템플릿 엔진" 이미지 참고

    /*
        private final MemberService service = new MemberService();
        이러식으로 new로 생성해서 사용할 수 있지만
        spring으로 관리를 하게 되면 스프링 컨테이너에 등록을 하고
        스프링 컨테이너에서 받아서 쓰도록 변경해야 함
        -> new 해서 하면 -> 다른 컨트롤러에서 이 서비스를 받아서 쓸 때 객체를 여러번 생성하게 됨
        --> 이럴 필요없이 스프링 컨테이너에 공통적으로 등록을하고(스프링 컨테이너에 등록하면 한번만 생성하게 됨)
        -> 이렇게 되면 여러가지 효과가 생길 수있음
     */
    /*
        constructor in hello.hellospring.controller.MemberController required a bean of type 'hello.hellospring.service.MemberService' that could not be found.

        해당 member 서비스를 가보면 순수 자바 클래스임
     */
    private final ComponentScanMemberService service;

    @Autowired
    public ComponentScanMemberController(ComponentScanMemberService service) {
        this.service = service;
    }

}
