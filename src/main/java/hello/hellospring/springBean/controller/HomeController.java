package hello.hellospring.springBean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : hello.hellospring.springBean.controller
 * fileName       : HomeController
 * author         : asdfz
 * date           : 2023-06-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-15        asdfz       최초 생성
 */
@Controller
public class HomeController {

    //우선순위
    //pdf 정적컨텐츠 이미지 부분에서 비슷하게
    //"/" 도메인 요청이 오면
    //1. 먼저 컨트롤러에서 맵핑된게 있는지 확인
    //2. 만약 없으면 index.html 리턴

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
