package hello.hello_string.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // hello 경로에 접속한다면 templates 경로의 아래 코드를 실행하고 hello2.html을 렌더링한다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello, Spring!");
        return "hello2";
    }
}
