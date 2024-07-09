package hello.hello_string.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // @ResponseBody를 사용하면 view를 사용하지 않고 HTTP의 body에 직접 데이터를 넣어준다.
    // 페이지 소스를 보면 html이 아닌 문자열이 들어가 있는 것을 확인할 수 있다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello-string" + name;
    }

    // API 방식: 객체를 반환하면 JSON 방식으로 데이터를 반환한다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
