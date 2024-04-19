package daelim.spring_ch08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 클래스가 Controller 빈 객체로 사용될 수 있게 선언
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
        System.out.println("Hello Controller >>> ");
        // Model 객체에 "greeting" 이라는 이름으로 데이터를 담음
        model.addAttribute("greeting", "안녕하세요," + name);

        // View에 필요한 정보를 hello 값으로 반환
        // '/WEB-INF/views/hello.jsp' 를 찾음
        return "hello";
    }
}