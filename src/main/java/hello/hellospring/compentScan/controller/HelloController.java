package hello.hellospring.compentScan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * packageName    : hello.hellospring.controller fileName       : HelloController author         :
 * asdfz date           : 2023-06-06 description    :
 * =========================================================== DATE              AUTHOR NOTE
 * ----------------------------------------------------------- 2023-06-06        asdfz       최초 생성
 */
@Controller
public class HelloController {

    /**
     * 정적 콘텐츠
     *
     * @param model Model
     * @return html file name
     */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring");
        return "hello";
    }

    /**
     * mvc 모델
     *
     * @param name  RequestParam
     * @param model Model
     * @return template file name
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name,
        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("ff", "ff");
        return "hello-template";
    }

    /**
     * API
     * ResponseBody: HTTP에서 body부에 내용을 직접 넣어주는거
     *
     * @param name RequestParam
     * @return "hello" + name; --> String으로 그대로 문자만 내려줌
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String hellString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    /**
     * API
     *
     * @param name RequestParam
     * @return json 형태로
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
        //retrun 할때 HttpMessageConverter 에서 return 형태에 따라 String이면 String, Object이면 json형태로
    }


    static class Hello {

        //getter setter
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
