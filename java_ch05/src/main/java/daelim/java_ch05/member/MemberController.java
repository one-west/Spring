package daelim.java_ch05.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    //@Autowired
    public MemberController(MemberService memberService) {
        System.out.println("MemberController()");
        //this.memberService = new MemberService();
    }

    @RequestMapping("/signUp")
    public String singUp() {
        return "sign_up";
    }

    @RequestMapping("signIn")
    public String signIn() {
        return "sign_in";
    }

    @RequestMapping("/signUpConfirm")
    public String signUpConfirm(MemberVo memberVo) {
        System.out.println("MemberController::signUpConfirm()");

        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        memberService.signUpCcnfirm(memberVo);

        return null;
    }
}
