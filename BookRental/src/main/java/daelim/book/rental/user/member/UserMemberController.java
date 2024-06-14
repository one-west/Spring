package daelim.book.rental.user.member;

import daelim.book.rental.admin.member.AdminMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/member")
public class UserMemberController {
    
    @Autowired
    private userMemberService userMemberService;
    
    @GetMapping("/logoutConfirm")
    public String logoutConfirm(HttpSession session) {
        System.out.println("[UserHomeController] logoutConfirm()");
        String nextPage = "redirect:/user/";
        session.invalidate();
        
        return nextPage;
    }
    
    @GetMapping("/loginForm")
    public String loginForm() {
        System.out.println("[UserHomeController] loginForm()");
        
        String nextPage = "user/member/login_form";
        
        return nextPage;
    }
    
    @GetMapping("/createAccountForm")
    public String createAccountForm() {
        System.out.println("[UserHomeController] createAccountForm()");
        
        String nextPage = "user/member/create_account_form";
        
        return nextPage;
    }
    
    @RequestMapping(value = "/createAccountConfirm", method = RequestMethod.POST)
    public String createAccountConfirm(UserMemberVo userMemberVo) {
        System.out.println("[UserHomeController] createAccountConfirm()");
        
        String nextPage = "/user/member/create_account_ok";
        int result = userMemberService.createAccount(userMemberVo);
        if (result <= 0) nextPage = "/user/member/create_account_ng";
        
        return nextPage;
    }
    
    @GetMapping("/modifyAccountForm")
    public String modifyAccountForm() {
        System.out.println("[UserHomeController] modifyAccountForm()");
        
        String nextPage = "user/member/modify_account_form";
        
        return nextPage;
    }
    
    @PostMapping("/modifyAccountConfirm")
    public String modifyAccountConfirm(UserMemberVo userMemberVo, HttpSession session) {
        System.out.println("[AdminMemberController] modifyAccountConfirm()");
        String nextPage = "/user/member/modify_account_ok";
        int result = userMemberService.modifyAccountConfirm(userMemberVo);
        
        if (result > 0) {
            UserMemberVo loginedAdminMemberVo = userMemberService.getLoginedAdminMemberVo(userMemberVo.getNo());
            
            session.setAttribute("loginedAdminMemberVo", loginedAdminMemberVo);
            session.setMaxInactiveInterval(60 * 30);
        } else {
            nextPage = "user/member/modify_account_ng";
        }
        return nextPage;
    }
    
    @PostMapping("/loginConfirm")
    public String loginConfirm(UserMemberVo userMemberVo, HttpSession session) {
        System.out.println("[UserMemberController] loginConfirm()");
        String nextPage = "/user/member/login_ok";
        UserMemberVo loginedUserMemberVo = userMemberService.loginConfirm(userMemberVo);
        
        if (loginedUserMemberVo == null) {
            nextPage = "/user/member/login_ng";
        } else {
            // session 설정
            session.setAttribute("loginedUserMemberVo", loginedUserMemberVo);
            session.setMaxInactiveInterval(60 * 30);
        }
        return nextPage;
    }
    
    @GetMapping("/findPasswordForm")
    public String findPasswordForm() {
        System.out.println("[UserHomeController] findPasswordForm()");
        
        String nextPage = "user/member/find_password_form";
        
        return nextPage;
    }
    
    @PostMapping("/findPasswordConfirm")
    public String findPasswordConfirm(UserMemberVo userMemberVo) {
        System.out.println("[UserHomeController] findPasswordConfirm()");
        String nextPage = "user/member/find_password_ok";
        int result = userMemberService.findPasswordConfirm(userMemberVo);
        
        if (result <= 0) {
            nextPage = "user/member/find_password_ng";
        }
        return nextPage;
    }
}

