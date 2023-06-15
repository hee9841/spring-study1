package hello.hellospring.springBean.controller;


import hello.hellospring.springBean.domain.Member;
import hello.hellospring.springBean.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMmberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        //spring이 알아서 MemberForm의 setName을 호출하여 name값을 넣어서 들어옴

        Member member = new Member();
        member.setName(form.getName());

        service.join(member);
        //
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = service.findMembers();
        model.addAttribute("members", members);

        return "/members/memberList";
    }
}
