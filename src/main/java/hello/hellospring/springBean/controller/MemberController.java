package hello.hellospring.springBean.controller;

import hello.hellospring.springBean.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * packageName    : hello.hellospring.springBean.controller
 * fileName       : SrpingBeanMemberController
 * author         : asdfz
 * date           : 2023-06-15
 * description    : 자바로 스프링 빈 생성을 위한 파일
 * Controller를 어쩔 수 없이 Autowired로 등록
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Controller
public class MemberController {

    //
    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

}
