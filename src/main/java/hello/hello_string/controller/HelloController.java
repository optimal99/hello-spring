package hello.hello_string.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // hello 경로에 접속한다면 templates 경로의 아래 코드를 실행하고 hello2.html을 렌더링한다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello, Spring!");
        return "hello2";
    }

    // @RequestParam(value="name", required=true)) 형태가 default이다.
    // required=false로 설정하면 name이라는 파라미터가 없어도 오류가 발생하지 않는다.
    // http://localhost:8080/hello-mvc?name=Spring 형태로 데이터를 전달한다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
